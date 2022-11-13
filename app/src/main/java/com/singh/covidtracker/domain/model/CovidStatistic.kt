package com.singh.covidtracker.domain.model

import java.util.*

data class CovidStatistic(
    val cases: CovidCases?,
    val deaths: CovidDeaths?,
    val tests: CovidTests?,
    val continent: String?,
    val country: String?,
    val population: Long?,
    val time: Date?,
    val day: String? = ""
)
