package com.singh.covidtracker.domain.useCase.impl

import com.singh.covidtracker.domain.model.CovidCases
import com.singh.covidtracker.domain.model.CovidDeaths
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.model.CovidTests
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.domain.useCase.WorldCovidStatisticsUseCase
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject

class WorldCovidStatisticsUseCaseImpl @Inject constructor(
    private val covidStatisticsRepo: CovidStatisticsRepo,
) : WorldCovidStatisticsUseCase {

    override val worldStatistics: Flow<State<CovidStatistic>>
        get() = covidStatisticsRepo.state.map {
            when (it) {
                is State.Error -> State.Error(it.throwable)
                is State.Success -> State.Success(buildWorldCovidStatistics(it.result))
                else -> State.Loading()
            }
        }

    private fun buildWorldCovidStatistics(covidStatistics: Map<String, CovidStatistic>): CovidStatistic {
        var newDeaths = 0L
        var totalDeaths = 0L
        var tests = 0L
        var newCases = 0L
        var totalCases = 0L
        var activeCases = 0L
        var criticalCases = 0L
        var recoveredCases = 0L
        var totalPopulation = 0L

        covidStatistics.forEach { entry ->
            try {
                with(entry.value) {
                    newDeaths += this.deaths?.new?.toLong() ?: 0L
                    totalDeaths += this.deaths?.total ?: 0L

                    tests += this.tests?.total ?: 0L

                    newCases += this.cases?.new?.toLong() ?: 0L
                    totalCases += this.cases?.total ?: 0L
                    activeCases += this.cases?.active ?: 0L
                    criticalCases += this.cases?.critical ?: 0L
                    recoveredCases += this.cases?.recovered ?: 0L

                    totalPopulation += this.population ?: 0L
                }
            } catch (_: Exception) {
            }
        }

        return CovidStatistic(
            deaths = CovidDeaths(newDeaths.toString(), totalDeaths),
            tests = CovidTests(tests),
            cases = CovidCases(
                newCases.toString(),
                activeCases,
                criticalCases,
                recoveredCases,
                totalCases
            ),
            continent = null,
            country = null,
            population = totalPopulation,
            time = Date(),
            day = ""
        )
    }
}