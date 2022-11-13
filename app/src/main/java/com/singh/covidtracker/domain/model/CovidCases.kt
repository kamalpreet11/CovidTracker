package com.singh.covidtracker.domain.model

data class CovidCases(
    val new: String?,
    val active: Long?,
    val critical : Long?,
    val recovered : Long?,
    val total : Long?
)