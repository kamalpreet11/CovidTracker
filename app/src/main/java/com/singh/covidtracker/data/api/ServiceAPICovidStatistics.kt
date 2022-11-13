package com.singh.covidtracker.data.api

import com.singh.covidtracker.data.dto.DTOCovidStatistics
import retrofit2.Response
import retrofit2.http.GET

interface ServiceAPICovidStatistics {
    @GET("statistics")
    suspend fun getStatistics() : Response<DTOCovidStatistics>
}