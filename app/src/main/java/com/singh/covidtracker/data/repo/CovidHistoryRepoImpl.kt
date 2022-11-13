package com.singh.covidtracker.data.repo

import com.jaikeerthick.composable_graphs.data.GraphData
import com.singh.covidtracker.data.api.ServiceAPIHistory
import com.singh.covidtracker.data.api.ServiceError
import com.singh.covidtracker.data.utils.DateFormatter
import com.singh.covidtracker.data.utils.mapToCovidStatistic
import com.singh.covidtracker.di.IODispatcher
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidHistoryGraphData
import com.singh.covidtracker.domain.repo.CovidHistoryRepo
import com.singh.covidtracker.utils.ERROR_NO_HISTORY
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CovidHistoryRepoImpl @Inject constructor(
    private val serviceAPIHistory: ServiceAPIHistory,
    private val dateFormatter: DateFormatter,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : CovidHistoryRepo {

    private val covidHistoryRequests =
        ConcurrentHashMap<Country, StateFlow<State<CovidHistoryGraphData>>>()

    override fun getHistory(
        country: Country,
        date: Date,
        scope: CoroutineScope
    ): StateFlow<State<CovidHistoryGraphData>> {
        return covidHistoryRequests[country] ?: run {
            val flow = MutableStateFlow<State<CovidHistoryGraphData>>(State.Loading())
            covidHistoryRequests[country] = flow
            scope.launch(dispatcher) {
                try {
                    val result =
                        serviceAPIHistory.getHistory(country.name.lowercase(Locale.getDefault()))
                    if (result.isSuccessful) {
                        result.body()?.let { dtoCovidStatistics ->
                            if (dtoCovidStatistics.statistics.isNotEmpty()) {
                                val allStats = dtoCovidStatistics.statistics.map { dtoCovidStatistic ->
                                    dtoCovidStatistic.mapToCovidStatistic(dateFormatter)
                                }
                                val statistics = allStats
                                    .filter { it.day != null }.associateBy { it.day!! }
                                val covidHistoryGraphData = CovidHistoryGraphData(
                                    startLabel = dateFormatter.getTimeString(
                                        allStats.last().time ?: Date()
                                    ),
                                    endLabel = dateFormatter.getTimeString(
                                        allStats.first().time ?: Date()
                                    ),
                                    graphData = Pair(
                                        statistics.entries
                                            .map { GraphData.String("") }.toList(),
                                        statistics.entries
                                            .map { (it.value.cases?.new?.toDouble() ?: 0.0) })
                                )
                                flow.emit(State.Success(covidHistoryGraphData))
                            } else {
                                errorNoHistory(flow)
                            }
                        } ?: run {
                            errorNoHistory(flow)
                        }
                    } else {
                        errorNoHistory(flow)
                    }
                } catch (e: Exception) {
                    if (e is CancellationException) {
                        throw e
                    }
                    flow.emit(
                        State.Error(
                            ServiceError(ERROR_NO_HISTORY, e.message, e)
                        )
                    )
                }
            }
            flow
        }
    }

    private suspend fun errorNoHistory(flow: MutableStateFlow<State<CovidHistoryGraphData>>) {
        flow.emit(
            State.Error(
                ServiceError(ERROR_NO_HISTORY)
            )
        )
    }
}