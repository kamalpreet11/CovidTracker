package com.singh.covidtracker.data.repo

import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.repo.SelectedCountryRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SelectedCountryRepoImpl @Inject constructor() : SelectedCountryRepo {

    private val _selectedCountry = MutableStateFlow<Country?>(null)
    override val selectedCountry: StateFlow<Country?> = _selectedCountry

    override suspend fun selectCountry(country: Country?) {
        _selectedCountry.emit(country)
    }
}