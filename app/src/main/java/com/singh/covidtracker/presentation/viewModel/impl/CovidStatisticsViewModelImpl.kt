package com.singh.covidtracker.presentation.viewModel.impl

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singh.covidtracker.R
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidHistoryGraphData
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidHistoryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.domain.repo.SelectedCountryRepo
import com.singh.covidtracker.domain.useCase.CountryCovidStatisticsUseCase
import com.singh.covidtracker.domain.useCase.WorldCovidStatisticsUseCase
import com.singh.covidtracker.presentation.viewModel.CovidStatisticsViewModel
import com.singh.covidtracker.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CovidStatisticsViewModelImpl @Inject constructor(
    private val application: Application,
    worldCovidStatisticsUseCase: WorldCovidStatisticsUseCase,
    countryRepo: CountryRepo,
    covidStatisticsRepo: CovidStatisticsRepo,
    private val selectedCountryRepo: SelectedCountryRepo,
    covidStatisticsUseCase: CountryCovidStatisticsUseCase,
    private val covidHistoryRepo: CovidHistoryRepo,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), CovidStatisticsViewModel {

    companion object {
        private const val SELECTED_COUNTRY = "selectedCountry"
    }

    init {
        viewModelScope.launch {
            countryRepo.initialize()
        }

        viewModelScope.launch {
            covidStatisticsRepo.initialize()
        }

        viewModelScope.launch {
            selectedCountryRepo.selectedCountry
                .collect { country ->
                    country?.let {
                        savedStateHandle[SELECTED_COUNTRY] = it
                    }
                }
        }
    }

    private val _selectedCountry = savedStateHandle.getStateFlow<Country?>(SELECTED_COUNTRY, null)

    override val selectedCountryCovidStatistic: StateFlow<State<Pair<Country, CovidStatistic?>>> =
        combine(
            _selectedCountry,
            covidStatisticsUseCase.countryCovidStatistics,
            worldCovidStatisticsUseCase.worldStatistics
        ) { selectedCountry, covidStatisticsResponse, worldCovidStatistics ->
            selectedCountry?.let { _country ->
                when (covidStatisticsResponse) {
                    is State.Success -> State.Success(_country to covidStatisticsResponse.result[_country])
                    is State.Error -> State.Error(covidStatisticsResponse.throwable)
                    else -> State.Loading()
                }
            } ?: when (worldCovidStatistics) {
                is State.Success -> State.Success<Pair<Country, CovidStatistic?>>(
                    Country(
                        application.getString(R.string.world),
                        ""
                    ) to worldCovidStatistics.result
                )
                is State.Error -> State.Error(worldCovidStatistics.throwable)
                else -> State.Loading()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), State.Loading())

    override val countries: StateFlow<State<List<Country>>> = countryRepo.state

    override fun showWorldStatistics() {
        viewModelScope.launch {
            savedStateHandle[SELECTED_COUNTRY] = null
            selectedCountryRepo.selectCountry(null)
        }
    }

    override fun fetchCovidStatistics(country: Country): StateFlow<State<CovidHistoryGraphData>> {
        return covidHistoryRepo.getHistory(country, scope = viewModelScope)
    }
}