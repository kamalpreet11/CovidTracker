package com.singh.covidtracker.domain.useCase

import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.Flow

interface WorldCovidStatisticsUseCase {
    val worldStatistics: Flow<State<CovidStatistic>>
}