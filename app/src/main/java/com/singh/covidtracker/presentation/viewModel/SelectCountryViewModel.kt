package com.singh.covidtracker.presentation.viewModel

import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.StateFlow

interface SelectCountryViewModel {
    val countries : StateFlow<State<List<Country>>>

    fun selectCountry(country: Country?)
}