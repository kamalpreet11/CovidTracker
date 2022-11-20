package com.singh.covidtracker.presentation.viewModel

import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.StateFlow

interface WorldCovidStatisticsViewModel {

    val worldCovidStatistic : StateFlow<State<CovidStatistic>>
}