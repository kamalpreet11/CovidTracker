package com.singh.covidtracker.data.repo

import com.google.common.truth.Truth
import com.singh.covidtracker.data.api.ServiceAPIHistory
import com.singh.covidtracker.data.dto.*
import com.singh.covidtracker.data.utils.DateFormatter
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.utils.State
import io.mockk.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class CovidHistoryRepoImplTest {

    private val mockServiceAPIHistory = mockk<ServiceAPIHistory>()

    private val mockDateFormatter = mockk<DateFormatter>()

    @Before
    fun setUp() {
        every { mockDateFormatter.getTime(any()) } returns Date()
        every { mockDateFormatter.getDayString(any()) } returns "2022-11-08"
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun getHistory() {
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

        coEvery { mockServiceAPIHistory.getHistory(any()) } returns mockResponse

        val repo = CovidHistoryRepoImpl(
            mockServiceAPIHistory,
            mockDateFormatter,
            UnconfinedTestDispatcher()
        )

        runBlocking {
            val resultFlow = repo.getHistory(
                Country("test", ""),
                Date(),
                CoroutineScope(UnconfinedTestDispatcher())
            )
            Truth.assertThat(resultFlow.first()).isInstanceOf(State.Success::class.java)
        }
    }

    @Test
    fun getHistoryMultiCall() {
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

        coEvery { mockServiceAPIHistory.getHistory("test") } returns mockResponse

        val repo = CovidHistoryRepoImpl(
            mockServiceAPIHistory,
            mockDateFormatter,
            UnconfinedTestDispatcher()
        )

        runBlocking {
            val resultFlow = repo.getHistory(
                Country("test", ""),
                Date(),
                CoroutineScope(UnconfinedTestDispatcher())
            )
            Truth.assertThat(resultFlow.first()).isInstanceOf(State.Success::class.java)

            repo.getHistory(
                Country("test", ""),
                Date(),
                CoroutineScope(UnconfinedTestDispatcher())
            )

            coVerify(exactly = 1) { mockServiceAPIHistory.getHistory("test") }
        }
    }

    @Test
    fun getHistoryServiceError() {

        val repo = CovidHistoryRepoImpl(
            mockServiceAPIHistory,
            mockDateFormatter,
            UnconfinedTestDispatcher()
        )

        runBlocking {
            val resultFlow = repo.getHistory(
                Country("test", ""),
                Date(),
                CoroutineScope(UnconfinedTestDispatcher())
            )
            Truth.assertThat(resultFlow.first()).isInstanceOf(State.Error::class.java)
        }
    }

    @Test
    fun getHistoryNoResult() {
        val mockResponse = mockk<Response<DTOCovidStatistics>>()
        every { mockResponse.isSuccessful } returns false

        coEvery { mockServiceAPIHistory.getHistory(any()) } returns mockResponse

        val repo = CovidHistoryRepoImpl(
            mockServiceAPIHistory,
            mockDateFormatter,
            UnconfinedTestDispatcher()
        )

        runBlocking {
            val resultFlow = repo.getHistory(
                Country("test", ""),
                Date(),
                CoroutineScope(UnconfinedTestDispatcher())
            )
            Truth.assertThat(resultFlow.first()).isInstanceOf(State.Error::class.java)
        }
    }

    @Test
    fun getHistoryNoData() {
        val mockDTOCovidStatistics = mockk<DTOCovidStatistics>()
        val mockResponse = mockk<Response<DTOCovidStatistics>>()

        every { mockResponse.isSuccessful } returns true
        every { mockResponse.body() } returns mockDTOCovidStatistics
        every { mockDTOCovidStatistics.statistics } returns mutableListOf<DTOCovidStatistic>()

        coEvery { mockServiceAPIHistory.getHistory(any()) } returns mockResponse

        val repo = CovidHistoryRepoImpl(
            mockServiceAPIHistory,
            mockDateFormatter,
            UnconfinedTestDispatcher()
        )

        runBlocking {
            val resultFlow = repo.getHistory(
                Country("test", ""),
                Date(),
                CoroutineScope(UnconfinedTestDispatcher())
            )
            Truth.assertThat(resultFlow.first()).isInstanceOf(State.Error::class.java)
        }
    }
}