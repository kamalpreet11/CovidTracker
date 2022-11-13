package com.singh.covidtracker.data.dto

import com.squareup.moshi.Json

data class DTOCovidDeaths(
    @field:Json(name = "new") val new: String?,
    @field:Json(name = "total") val total : Long?
)

/*
"deaths": {
        "new": null,
        "1M_pop": "4",
        "total": 5226
      }
 */