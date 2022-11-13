package com.singh.covidtracker.data.dto

import com.squareup.moshi.Json

data class DTOCovidTests(
    @field:Json(name = "total") val total : Long?
)

/*
"tests": {
        "1M_pop": null,
        "total": null
      }
 */