package com.singh.covidtracker.presentation.viewModel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.domain.useCase.WorldCovidStatisticsUseCase
import com.singh.covidtracker.presentation.viewModel.WorldCovidStatisticsViewModel
import com.singh.covidtracker.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorldStatisticsViewModelImpl @Inject constructor(
    private val worldCovidStatisticsUseCase: WorldCovidStatisticsUseCase,
    countryRepo: CountryRepo,
    covidStatisticsRepo: CovidStatisticsRepo,
) : WorldCovidStatisticsViewModel, ViewModel() {

    init {
        viewModelScope.launch {
            val country = async {
                countryRepo.initialize()
            }
            val statistics = async {
                covidStatisticsRepo.initialize()
            }
            awaitAll(country, statistics)
        }
    }

    override val worldCovidStatistic: StateFlow<State<CovidStatistic>>
        get() = worldCovidStatisticsUseCase.worldStatistics.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(), State.Loading()
        )
}