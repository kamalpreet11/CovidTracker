package com.singh.covidtracker.data.network

import android.app.Application
import com.singh.covidtracker.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.inject.Inject

class MockResponseInterceptor @Inject constructor(private val application: Application) :
    Interceptor {

    companion object {
        private const val SAMPLE_COUNTRIES = "countries.json"
        private const val SAMPLE_STATISTICS = "statistics.json"
        private const val SAMPLE_HISTORY = "history.json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        return if (BuildConfig.USE_MOCK) {
            val url = chain.request().url.toUri().toString()
            val responseString = when {
                url.endsWith("countries") -> readData(SAMPLE_COUNTRIES)
                url.endsWith("statistics") -> readData(SAMPLE_STATISTICS)
                url.contains("history") -> readData(SAMPLE_HISTORY)
                else -> null
            }

            responseString?.let {
                Response.Builder()
                    .code(200)
                    .protocol(Protocol.HTTP_1_1)
                    .message("OK")
                    .body(it.toResponseBody("application/json".toMediaType()))
                    .addHeader("content-type", "application/json")
                    .request(chain.request())
                    .build()
            } ?: proceedNormal(chain)
        } else {
            proceedNormal(chain)
        }
    }

    private fun proceedNormal(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }

    private fun readData(fileName: String): String? {
        return try {
            application.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}