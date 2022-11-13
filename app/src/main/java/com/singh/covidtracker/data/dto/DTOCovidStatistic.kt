package com.singh.covidtracker.data.dto

import com.squareup.moshi.Json

data class DTOCovidStatistic(
    @field:Json(name = "cases") val cases: DTOCovidCases?,
    @field:Json(name = "deaths") val deaths: DTOCovidDeaths?,
    @field:Json(name = "tests") val tests: DTOCovidTests?,
    @field:Json(name = "continent") val continent: String?,
    @field:Json(name = "country") val country: String?,
    @field:Json(name = "population") val population: Long?,
    @field:Json(name = "day") val day: String?,
    @field:Json(name = "time") val time: String?,
)

/*
{
      "continent": "Africa",
      "country": "Saint-Helena",
      "population": 6118,
      "cases": {
        "new": null,
        "active": 1746,
        "critical": null,
        "recovered": 2,
        "1M_pop": "285714",
        "total": 1748
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": null
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    }
 */
