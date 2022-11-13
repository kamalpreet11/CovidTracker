package com.singh.covidtracker.data.api

import com.singh.covidtracker.data.dto.DTOCountryList
import retrofit2.Response
import retrofit2.http.GET

interface ServiceAPICountries {
    @GET("countries")
    suspend fun getCountries() : Response<DTOCountryList>
}