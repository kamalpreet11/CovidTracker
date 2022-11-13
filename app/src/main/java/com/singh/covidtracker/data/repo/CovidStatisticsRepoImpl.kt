package com.singh.covidtracker.data.repo

import android.app.Application
import android.util.Log
import com.singh.covidtracker.R
import com.singh.covidtracker.data.api.ServiceAPICovidStatistics
import com.singh.covidtracker.data.api.ServiceError
import com.singh.covidtracker.data.utils.DateFormatter
import com.singh.covidtracker.data.utils.mapToCovidStatistic
import com.singh.covidtracker.di.IODispatcher
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.utils.ERROR_INTERNAL
import com.singh.covidtracker.utils.ERROR_NO_STATISTICS
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CovidStatisticsRepoImpl @Inject constructor(
    private val application: Application,
    private val serviceAPICovidStatistics: ServiceAPICovidStatistics,
    private val dateFormatter: DateFormatter,
    @IODispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CovidStatisticsRepo {

    override val state =
        MutableStateFlow<State<Map<String, CovidStatistic>>>(State.Loading())

    override suspend fun initialize() {
        withContext(dispatcher) {
            try {
                fetchCovidStatistics()
            } catch (e: Exception) {
                if (e is CancellationException) {
                    throw e
                }
                reportError(
                    ServiceError(
                        ERROR_INTERNAL,
                        e.message,
                        e
                    )
                )
            }
        }
    }

    private suspend fun fetchCovidStatistics() {
        val response = serviceAPICovidStatistics.getStatistics()
        if (response.isSuccessful) {
            response.body()?.let { dtoCovidStatistics ->
                if (dtoCovidStatistics.statistics.isNotEmpty()) {

                    val countryStatistics = dtoCovidStatistics.statistics
                        .filter { it.country != null }
                        .map { statistic ->
                            statistic.mapToCovidStatistic(dateFormatter)
                        }
                        .associateBy { it.country!! }

                    state.emit(State.Success(countryStatistics))
                } else {
                    reportError(
                        ServiceError(
                            ERROR_NO_STATISTICS,
                            application.getString(R.string.error_no_statistics_found)
                        )
                    )
                }
            } ?: run {
                reportError(
                    ServiceError(
                        ERROR_NO_STATISTICS,
                        application.getString(R.string.error_no_statistics_found)
                    )
                )
            }
        } else {
            reportError(
                ServiceError(
                    response.code(),
                    response.message()
                )
            )
        }
    }

    private suspend fun reportError(error: ServiceError) {
        state.emit(State.Error(error))
        logError(error)
    }

    private fun logError(error: Throwable) {
        Log.e("CovidStatisticsRepo", "Error occurred: $error")
    }
}