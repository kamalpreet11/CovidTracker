package com.singh.covidtracker.data.repo

import android.app.Application
import com.google.common.truth.Truth
import com.singh.covidtracker.BaseTest
import com.singh.covidtracker.data.api.ServiceAPICountries
import com.singh.covidtracker.data.api.ServiceError
import com.singh.covidtracker.data.dto.DTOCountryList
import com.singh.covidtracker.data.network.UriEncoder
import com.singh.covidtracker.utils.ERROR_INTERNAL
import com.singh.covidtracker.utils.ERROR_NO_COUNTRIES
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class CountryRepoImplTest : BaseTest() {

    private val mockkApplication = mockk<Application>()

    private val mockServiceAPICountries = mockk<ServiceAPICountries>()

    private val mockUriEncoder = mockk<UriEncoder>()

    @Before
    override fun setUp() {
        super.setUp()
        every { mockUriEncoder.encodeUrl(any()) } returns "https://flag"
        every { mockkApplication.getString(any()) } returns "string"
    }

    @After
    override fun tearDown() {
        super.tearDown()
    }

    @Test
    fun getCountries() {

        val mockResponseCountries = mockk<Response<DTOCountryList>>()

        every { mockResponseCountries.isSuccessful } returns true
        every { mockResponseCountries.body() } returns DTOCountryList(
            "get", 1, mutableListOf<String>().apply {
                add("test")
            }
        )

        coEvery { mockServiceAPICountries.getCountries() } returns mockResponseCountries

        val countryRepo = CountryRepoImpl(
            mockkApplication,
            mockServiceAPICountries,
            mockUriEncoder,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(countryRepo.state).isNotNull()
        Truth.assertThat(countryRepo.state.value).isNotNull()
        Truth.assertThat(countryRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Success::class.java)
        val response = countryRepo.state.value as com.singh.covidtracker.utils.State.Success
        Truth.assertThat(response.result).isNotEmpty()
        Truth.assertThat(response.result[0].name).isEqualTo("test")
    }

    @Test
    fun getCountries_unSuccessful_response() {

        val mockResponseCountries = mockk<Response<DTOCountryList>>()

        every { mockResponseCountries.isSuccessful } returns false

        coEvery { mockServiceAPICountries.getCountries() } returns mockResponseCountries

        val countryRepo = CountryRepoImpl(
            mockkApplication,
            mockServiceAPICountries,
            mockUriEncoder,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(countryRepo.state).isNotNull()
        Truth.assertThat(countryRepo.state.value).isNotNull()
        Truth.assertThat(countryRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Error::class.java)
    }

    @Test
    fun getCountries_response_no_body() {

        val mockResponseCountries = mockk<Response<DTOCountryList>>()

        every { mockResponseCountries.isSuccessful } returns false
        every { mockResponseCountries.body() } returns null

        coEvery { mockServiceAPICountries.getCountries() } returns mockResponseCountries

        val countryRepo = CountryRepoImpl(
            mockkApplication,
            mockServiceAPICountries,
            mockUriEncoder,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(countryRepo.state).isNotNull()
        Truth.assertThat(countryRepo.state.value).isNotNull()
        Truth.assertThat(countryRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Error::class.java)
    }

    @Test
    fun getCountries_empty_countries() {

        val mockResponseCountries = mockk<Response<DTOCountryList>>()

        every { mockResponseCountries.isSuccessful } returns true
        every { mockResponseCountries.body() } returns DTOCountryList(
            "get", 0, emptyList()
        )

        coEvery { mockServiceAPICountries.getCountries() } returns mockResponseCountries

        val countryRepo = CountryRepoImpl(
            mockkApplication,
            mockServiceAPICountries,
            mockUriEncoder,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(countryRepo.state).isNotNull()
        Truth.assertThat(countryRepo.state.value).isNotNull()
        Truth.assertThat(countryRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Error::class.java)
        Truth.assertThat((countryRepo.state.value as com.singh.covidtracker.utils.State.Error).throwable).isInstanceOf(ServiceError::class.java)
        val error = (countryRepo.state.value as com.singh.covidtracker.utils.State.Error).throwable
        Truth.assertThat((error as ServiceError).code).isEqualTo(ERROR_NO_COUNTRIES)
    }

    @Test
    fun getCountries_exception() {

        val mockResponseCountries = mockk<Response<DTOCountryList>>()

        every { mockResponseCountries.isSuccessful } returns true
        every { mockResponseCountries.body() } throws java.lang.Exception("Error")

        coEvery { mockServiceAPICountries.getCountries() } returns mockResponseCountries

        val countryRepo = CountryRepoImpl(
            mockkApplication,
            mockServiceAPICountries,
            mockUriEncoder,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(countryRepo.state).isNotNull()
        Truth.assertThat(countryRepo.state.value).isNotNull()
        Truth.assertThat(countryRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Error::class.java)
        Truth.assertThat((countryRepo.state.value as com.singh.covidtracker.utils.State.Error).throwable).isInstanceOf(ServiceError::class.java)
        val error = (countryRepo.state.value as com.singh.covidtracker.utils.State.Error).throwable
        Truth.assertThat((error as ServiceError).code).isEqualTo(ERROR_INTERNAL)
    }

    @Test
    fun getCountries_dual_initialization() {

        val mockResponseCountries = mockk<Response<DTOCountryList>>()

        every { mockResponseCountries.isSuccessful } returns true
        every { mockResponseCountries.body() } returns DTOCountryList(
            "get", 1, mutableListOf<String>().apply {
                add("test")
            }
        )

        coEvery { mockServiceAPICountries.getCountries() } returns mockResponseCountries

        val countryRepo = CountryRepoImpl(
            mockkApplication,
            mockServiceAPICountries,
            mockUriEncoder,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(countryRepo.state).isNotNull()
        Truth.assertThat(countryRepo.state.value).isNotNull()
        Truth.assertThat(countryRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Success::class.java)
        val response = countryRepo.state.value as com.singh.covidtracker.utils.State.Success
        Truth.assertThat(response.result).isNotEmpty()
        Truth.assertThat(response.result[0].name).isEqualTo("test")

        runTest {
            countryRepo.initialize()
        }
        coVerify(exactly = 1) { mockServiceAPICountries.getCountries() }
    }
}