package com.singh.covidtracker.presentation.viewModel

import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidHistoryGraphData
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.StateFlow

interface CovidStatisticsViewModel {

    val selectedCountryCovidStatistic : StateFlow<State<Pair<Country, CovidStatistic?>>>

    val countries : StateFlow<State<List<Country>>>

    fun showWorldStatistics()

    fun fetchCovidStatistics(country: Country) : StateFlow<State<CovidHistoryGraphData>>
}