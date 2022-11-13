package com.singh.covidtracker

import android.util.Log
import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

@OptIn(DelicateCoroutinesApi::class)
open class BaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    open fun setUp() {
        mockLogger()
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    open fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
        clearAllMocks()
        unMockLogger()
    }

    private fun mockLogger() {
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 1
        every { Log.e(any(), any()) } returns 1
    }

    private fun unMockLogger() {
        unmockkStatic(Log::class)
    }

}