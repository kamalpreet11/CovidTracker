package com.singh.covidtracker.domain.useCase.impl

import com.google.common.truth.Truth
import com.singh.covidtracker.BaseTest
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.utils.State
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CountryCovidStatisticsUseCaseImplTest : BaseTest() {

    private val mockCountryRepo = mockk<CountryRepo>()
    private val mockCovidStatisticsRepo = mockk<CovidStatisticsRepo>()

    @Test
    fun getCountryCovidStatistics_empty_stats() {
        runTest {
            every {
                mockCountryRepo.state
            } returns flow {
                emit(State.Success<List<Country>>(mutableListOf()))
            }.stateIn(this)

            every {
                mockCovidStatisticsRepo.state
            } returns flow {
                emit(State.Success<Map<String, CovidStatistic>>(mutableMapOf()))
            }.stateIn(this)

            val countryCovidStatisticsUseCase =
                CountryCovidStatisticsUseCaseImpl(mockCountryRepo, mockCovidStatisticsRepo)

            val result = countryCovidStatisticsUseCase.countryCovidStatistics.first()

            Truth.assertThat(result).isInstanceOf(State.Error::class.java)
        }
    }

    @Test
    fun getCountryCovidStatistics_list_of_countries() {

        runTest {
            val country = Country("USA", "flag")
            every {
                mockCountryRepo.state
            } returns flow {
                emit(State.Success<List<Country>>(mutableListOf<Country>().apply {
                    add(country)
                }))
            }.stateIn(this)

            every {
                mockCovidStatisticsRepo.state
            } returns flow {
                emit(State.Error<Map<String, CovidStatistic>>(Throwable("")))
            }.stateIn(this)

            val countryCovidStatisticsUseCase =
                CountryCovidStatisticsUseCaseImpl(mockCountryRepo, mockCovidStatisticsRepo)

            val result = countryCovidStatisticsUseCase.countryCovidStatistics.first()

            Truth.assertThat(result).isInstanceOf(State.Error::class.java)
        }
    }

    @Test
    fun getCountryCovidStatistics_error_countries() {

        runTest {
            every {
                mockCountryRepo.state
            } returns flow {
                emit(State.Error<List<Country>>(Throwable("")))
            }.stateIn(this)

            every {
                mockCovidStatisticsRepo.state
            } returns flow {
                emit(State.Error<Map<String, CovidStatistic>>(Throwable("")))
            }.stateIn(this)

            val countryCovidStatisticsUseCase =
                CountryCovidStatisticsUseCaseImpl(mockCountryRepo, mockCovidStatisticsRepo)

            val result = countryCovidStatisticsUseCase.countryCovidStatistics.first()

            Truth.assertThat(result).isInstanceOf(State.Error::class.java)
        }
    }

    @Test
    fun getCountryCovidStatistics() {

        runTest {
            val country = Country("USA", "flag")
            val statistic = CovidStatistic(
                null,
                null,
                null,
                "",
                "USA",
                1,
                null
            )

            every {
                mockCountryRepo.state
            } returns flow {
                emit(State.Success<List<Country>>(mutableListOf<Country>().apply {
                    add(country)
                }))
            }.stateIn(this)

            every {
                mockCovidStatisticsRepo.state
            } returns flow {
                emit(
                    State.Success<Map<String, CovidStatistic>>(
                        mutableMapOf<String, CovidStatistic>().apply {
                            put("USA", statistic)
                        }
                    )
                )
            }.stateIn(this)

            val countryCovidStatisticsUseCase =
                CountryCovidStatisticsUseCaseImpl(mockCountryRepo, mockCovidStatisticsRepo)

            val result = countryCovidStatisticsUseCase.countryCovidStatistics.first()

            Truth.assertThat(result).isInstanceOf(State.Success::class.java)
            Truth.assertThat((result as State.Success).result).isNotEmpty()
            Truth.assertThat(result.result.containsKey(country)).isTrue()
            Truth.assertThat(result.result[country]).isEqualTo(statistic)
        }
    }
}