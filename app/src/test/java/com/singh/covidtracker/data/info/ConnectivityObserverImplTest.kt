package com.singh.covidtracker.data.info

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.singh.covidtracker.BaseTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ConnectivityObserverImplTest : BaseTest() {

    private val connectivityManager = ApplicationProvider.getApplicationContext<Context>()
        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Before
    override fun setUp() {
        super.setUp()
    }

    @After
    override fun tearDown() {
        super.tearDown()
    }

    @Test
    fun observe() {
        Truth.assertThat(connectivityManager.activeNetwork).isNotNull()
        val activeNetwork = connectivityManager.activeNetwork!!

        Shadows.shadowOf(connectivityManager.getNetworkCapabilities(activeNetwork))
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)

        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

        Truth.assertThat(networkCapabilities).isNotNull()
        Truth.assertThat(networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
            .isTrue()
        /**
         * It is not possible to test callBackFlow as Robolectric does not trigger the network
         * callback.
         * Only way to trigger network callback is to
        Shadows.shadowOf(connectivityManager).networkCallbacks.forEach { callback ->
        callback.onAvailable(activeNetwork)
        }
         *
         * The problem is that implementation uses callbackFlow which prevents calling above hack
         * due to flow cold nature.
         */
    }
}