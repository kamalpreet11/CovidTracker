package com.singh.covidtracker.data.repo

import com.google.common.truth.Truth
import com.singh.covidtracker.BaseTest
import com.singh.covidtracker.domain.model.Country
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SelectedCountryRepoImplTest : BaseTest() {

    private val selectedCountryRepo = SelectedCountryRepoImpl()

    @Before
    override fun setUp() {
        super.setUp()
    }

    @After
    override fun tearDown() {
        super.tearDown()
    }

    @Test
    fun selectCountry() {

        val country = Country("USA", "")

        runTest {
            selectedCountryRepo.selectCountry(country)
            val result = selectedCountryRepo.selectedCountry.first()

            Truth.assertThat(result).isEqualTo(country)
        }
    }
}