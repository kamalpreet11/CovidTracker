package com.singh.covidtracker.presentation.viewModel.impl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singh.covidtracker.data.api.ServiceError
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidHistoryGraphData
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidHistoryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.domain.repo.SelectedCountryRepo
import com.singh.covidtracker.domain.useCase.CountryCovidStatisticsUseCase
import com.singh.covidtracker.presentation.viewModel.CovidStatisticsViewModel
import com.singh.covidtracker.utils.ERROR_NO_COUNTRIES
import com.singh.covidtracker.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CovidStatisticsViewModelImpl @Inject constructor(
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
            val country = async {
                countryRepo.initialize()
            }
            val statistics = async {
                covidStatisticsRepo.initialize()
            }
            awaitAll(country, statistics)
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
            covidStatisticsUseCase.countryCovidStatistics
        ) { selectedCountry, covidStatisticsResponse ->
            selectedCountry?.let { _country ->
                when (covidStatisticsResponse) {
                    is State.Success -> State.Success(_country to covidStatisticsResponse.result[_country])
                    is State.Error -> State.Error(covidStatisticsResponse.throwable)
                    else -> State.Loading()
                }
            } ?: when (covidStatisticsResponse) {
                is State.Success -> {
                    if (covidStatisticsResponse.result.isNotEmpty()) {
                        val entry = covidStatisticsResponse.result.entries.first()
                        State.Success(
                            entry.key to entry.value
                        )
                    } else {
                        State.Error(ServiceError(code = ERROR_NO_COUNTRIES))
                    }
                }
                is State.Error -> State.Error(covidStatisticsResponse.throwable)
                else -> State.Loading()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), State.Loading())

    override val countries: StateFlow<State<List<Country>>> = countryRepo.state

    override fun fetchCovidStatistics(country: Country): StateFlow<State<CovidHistoryGraphData>> {
        return covidHistoryRepo.getHistory(country, scope = viewModelScope)
    }
}