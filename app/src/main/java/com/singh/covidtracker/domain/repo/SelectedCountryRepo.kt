package com.singh.covidtracker.domain.repo

import com.singh.covidtracker.domain.model.Country
import kotlinx.coroutines.flow.StateFlow

interface SelectedCountryRepo {

    val selectedCountry : StateFlow<Country?>

    suspend fun selectCountry(country: Country? = null)
}