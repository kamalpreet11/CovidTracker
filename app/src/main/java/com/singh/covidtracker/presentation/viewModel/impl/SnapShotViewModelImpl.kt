package com.singh.covidtracker.presentation.viewModel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.presentation.viewModel.SnapShotViewModel
import com.singh.covidtracker.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SnapShotViewModelImpl @Inject constructor(
    countryRepo: CountryRepo,
    covidStatisticsRepo: CovidStatisticsRepo,
): ViewModel(), SnapShotViewModel {

    private val _appDataReady = MutableStateFlow<State<Boolean>>(State.Unknown())
    override val appDataReady: StateFlow<State<Boolean>> = _appDataReady

    init {
        viewModelScope.launch {
            combine(
                countryRepo.state,
                covidStatisticsRepo.state
            ) { countries, stats ->
                when(countries) {
                    is State.Success -> {
                        when (stats) {
                            is State.Success -> _appDataReady.emit(State.Success(true))
                            is State.Error -> _appDataReady.emit(State.Error(stats.throwable))
                            else -> _appDataReady.emit(State.Loading())
                        }
                    }
                    is State.Error -> _appDataReady.emit(State.Error(countries.throwable))
                    else -> _appDataReady.emit(State.Loading())
                }
            }.stateIn(viewModelScope)
        }
        viewModelScope.launch {
            countryRepo.initialize()
        }
        viewModelScope.launch {
            covidStatisticsRepo.initialize()
        }
    }
}