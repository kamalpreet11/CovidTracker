package com.singh.covidtracker.data.dto

import com.squareup.moshi.Json

data class DTOCovidCases(
    @field:Json(name = "new") val new: String?,
    @field:Json(name = "active") val active: Long?,
    @field:Json(name = "critical") val critical : Long?,
    @field:Json(name = "recovered") val recovered : Long?,
    @field:Json(name = "total") val total : Long?
)

/*
"cases": {
        "new": null,
        "active": 1746,
        "critical": null,
        "recovered": 2,
        "1M_pop": "285714",
        "total": 1748
      }
 */