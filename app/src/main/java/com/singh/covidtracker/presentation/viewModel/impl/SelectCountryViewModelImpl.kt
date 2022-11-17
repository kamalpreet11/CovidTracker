package com.singh.covidtracker.presentation.viewModel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.SelectedCountryRepo
import com.singh.covidtracker.presentation.viewModel.SelectCountryViewModel
import com.singh.covidtracker.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectCountryViewModelImpl @Inject constructor(
    countryRepo: CountryRepo,
    private val selectedCountryRepo: SelectedCountryRepo,
) : ViewModel(), SelectCountryViewModel {

    companion object {
        private const val SELECTED_COUNTRY = "selectedCountry"
    }

    init {
        viewModelScope.launch {
            countryRepo.initialize()
        }
    }

    override val countries: StateFlow<State<List<Country>>> = countryRepo.state

    override fun selectCountry(country: Country?) {
        viewModelScope.launch {
            selectedCountryRepo.selectCountry(country)
        }
    }
}