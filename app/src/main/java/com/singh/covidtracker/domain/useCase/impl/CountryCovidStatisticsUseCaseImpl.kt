package com.singh.covidtracker.domain.useCase.impl

import com.singh.covidtracker.data.api.ServiceError
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.domain.useCase.CountryCovidStatisticsUseCase
import com.singh.covidtracker.utils.ERROR_NO_COUNTRIES
import com.singh.covidtracker.utils.ERROR_NO_STATISTICS
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class CountryCovidStatisticsUseCaseImpl @Inject constructor(
    countryRepo: CountryRepo,
    covidStatisticsRepo: CovidStatisticsRepo,
) : CountryCovidStatisticsUseCase {

    override val countryCovidStatistics: Flow<State<Map<Country, CovidStatistic?>>> =
        countryRepo.state.combine(covidStatisticsRepo.state) { countryResponse, covidStatisticsResponse ->
            when (countryResponse) {
                is State.Success -> {
                    when (covidStatisticsResponse) {
                        is State.Success -> {
                            if (countryResponse.result.isEmpty()) {
                                State.Error(ServiceError(ERROR_NO_COUNTRIES))
                            } else if (covidStatisticsResponse.result.isEmpty()) {
                                State.Error(ServiceError(ERROR_NO_STATISTICS))
                            } else {
                                State.Success(countryResponse.result.associateWith {
                                    covidStatisticsResponse.result[it.name]
                                })
                            }
                        }
                        is State.Error -> State.Error(covidStatisticsResponse.throwable)
                        else -> State.Loading()
                    }
                }
                is State.Error -> State.Error(ServiceError(ERROR_NO_COUNTRIES))
                else -> State.Loading()
            }
        }
}