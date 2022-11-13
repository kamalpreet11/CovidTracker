package com.singh.covidtracker.data.api

import com.singh.covidtracker.data.dto.DTOCovidStatistics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPIHistory {
    @GET("history")
    suspend fun getHistory(
        @Query("country", encoded = false) countryName: String
    ): Response<DTOCovidStatistics>
}