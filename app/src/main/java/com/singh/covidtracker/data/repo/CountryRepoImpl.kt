package com.singh.covidtracker.data.repo

import android.app.Application
import android.util.Log
import com.singh.covidtracker.R
import com.singh.covidtracker.data.api.ServiceAPICountries
import com.singh.covidtracker.data.api.ServiceError
import com.singh.covidtracker.data.network.UriEncoder
import com.singh.covidtracker.di.IODispatcher
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.utils.ERROR_INTERNAL
import com.singh.covidtracker.utils.ERROR_NO_COUNTRIES
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.internal.platform.android.AndroidLogHandler.reportError
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepoImpl @Inject constructor(
    private val application: Application,
    private val serviceAPICountries: ServiceAPICountries,
    private val uriEncoder: UriEncoder,
    @IODispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CountryRepo {

    override val state =
        MutableStateFlow<State<List<Country>>>(State.Unknown())

    override suspend fun initialize() {
        withContext(dispatcher) {
            if (state.value is State.Unknown) {
                withContext(dispatcher) {
                    try {
                        fetchCountriesList()
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
        }
    }

    private suspend fun fetchCountriesList() {
        val response = serviceAPICountries.getCountries()

        if (!response.isSuccessful) {
            reportError(
                ServiceError(
                    response.code(),
                    response.message()
                )
            )
        } else {
            response.body()?.let { _body ->
                val countryList = _body.countries.map { _countryName ->
                    val countryName = _countryName.replace("-", " ")
                    Country(
                        name = countryName,
                        flag = "https://countryflagsapi.com/png/${
                            uriEncoder.encodeUrl(countryName)
                        }"
                    )
                }
                if (countryList.isNotEmpty()) {
                    state.emit(State.Success(countryList))
                } else {
                    reportError(
                        ServiceError(
                            ERROR_NO_COUNTRIES,
                            application.getString(R.string.error_no_countries_found)
                        )
                    )
                }
            } ?: run {
                reportError(
                    ServiceError(
                        ERROR_NO_COUNTRIES,
                        application.getString(R.string.error_no_countries_found)
                    )
                )
            }
        }
    }

    private suspend fun reportError(error: ServiceError) {
        state.emit(State.Error(error))
        logError(error)
    }

    private fun logError(error: Throwable) {
        Log.e("CountryRepo", "Error occurred: $error")
    }
}