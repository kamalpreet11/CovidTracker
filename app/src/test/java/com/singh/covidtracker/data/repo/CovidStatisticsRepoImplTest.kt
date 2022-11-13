package com.singh.covidtracker.data.repo

import android.app.Application
import com.google.common.truth.Truth
import com.singh.covidtracker.BaseTest
import com.singh.covidtracker.data.api.ServiceAPICovidStatistics
import com.singh.covidtracker.data.dto.*
import com.singh.covidtracker.data.utils.DateFormatter
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class CovidStatisticsRepoImplTest : BaseTest() {

    private val mockApplication = mockk<Application>()

    private val mockServiceAPICovidStatistics = mockk<ServiceAPICovidStatistics>()

    private val mockDateFormatter = mockk<DateFormatter>()

    @Before
    override fun setUp() {
        super.setUp()
        every { mockDateFormatter.getTime(any()) } returns Date()
        every { mockApplication.getString(any()) } returns "string"
    }

    @After
    override fun tearDown() {
        super.tearDown()
    }

    @Test
    fun getCovidStatistics() {
        val mockDTOCovidStatistics = mockk<DTOCovidStatistics>()
        val mockResponse = mockk<Response<DTOCovidStatistics>>()

        every { mockResponse.isSuccessful } returns true
        every { mockResponse.body() } returns mockDTOCovidStatistics
        every { mockDTOCovidStatistics.statistics } returns mutableListOf<DTOCovidStatistic>().apply {
            val statistics = DTOCovidStatistic(
                continent = "test",
                country = "test",
                day = "day",
                time = "time",
                population = 1,
                cases = DTOCovidCases(
                    "1",
                    1,
                    1,
                    1,
                    1
                ),
                deaths = DTOCovidDeaths(
                    "1",
                    1
                ),
                tests = DTOCovidTests(
                    1
                )
            )
            add(statistics)
        }

        coEvery { mockServiceAPICovidStatistics.getStatistics() } returns mockResponse

        val covidStatisticsRepo = CovidStatisticsRepoImpl(
            mockApplication,
            mockServiceAPICovidStatistics,
            mockDateFormatter,
            Dispatchers.Main
        ).apply {
            runTest { initialize() }
        }

        Truth.assertThat(covidStatisticsRepo.state).isNotNull()
        Truth.assertThat(covidStatisticsRepo.state.value).isNotNull()
        Truth.assertThat(covidStatisticsRepo.state.value).isInstanceOf(com.singh.covidtracker.utils.State.Success::class.java)
        val response = covidStatisticsRepo.state.value as com.singh.covidtracker.utils.State.Success
        Truth.assertThat(response.result).isNotEmpty()
        Truth.assertThat(response.result).containsKey("test")
    }
}