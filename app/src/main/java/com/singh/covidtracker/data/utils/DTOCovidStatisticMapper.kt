package com.singh.covidtracker.data.utils

import com.singh.covidtracker.data.dto.DTOCovidStatistic
import com.singh.covidtracker.domain.model.CovidCases
import com.singh.covidtracker.domain.model.CovidDeaths
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.model.CovidTests

fun DTOCovidStatistic.mapToCovidStatistic(dateFormatter: DateFormatter) : CovidStatistic {
    val covidCases = CovidCases(
        new = cases?.new,
        active = cases?.active,
        critical = cases?.critical,
        recovered = cases?.recovered,
        total = cases?.total
    )

    val covidDeaths = CovidDeaths(
        new = deaths?.new,
        total = deaths?.total
    )

    val covidTests = CovidTests(
        total = tests?.total
    )
    return CovidStatistic(
        cases = covidCases,
        deaths = covidDeaths,
        tests = covidTests,
        continent = continent,
        country = country?.replace("-", " "),
        population = population,
        time = time?.let {
            dateFormatter.getTime(it)
        },
        day = day
    )
}