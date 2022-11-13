package com.singh.covidtracker.data.dto

import com.squareup.moshi.Json

data class DTOCovidStatistics(
    @field:Json(name = "results") val total: Long,
    @field:Json(name = "response") val statistics: List<DTOCovidStatistic>,
)

/*
{
  "get": "statistics",
  "parameters": [],
  "errors": [],
  "results": 242,
  "response": [
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
    },
    {
      "continent": "North-America",
      "country": "Montserrat",
      "population": 4999,
      "cases": {
        "new": null,
        "active": 19,
        "critical": null,
        "recovered": 1376,
        "1M_pop": "280656",
        "total": 1403
      },
      "deaths": {
        "new": null,
        "1M_pop": "1600",
        "total": 8
      },
      "tests": {
        "1M_pop": "3553111",
        "total": 17762
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": "Asia",
      "country": "Macao",
      "population": 669569,
      "cases": {
        "new": null,
        "active": 0,
        "critical": null,
        "recovered": 787,
        "1M_pop": "1184",
        "total": 793
      },
      "deaths": {
        "new": null,
        "1M_pop": "9",
        "total": 6
      },
      "tests": {
        "1M_pop": "11724",
        "total": 7850
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Wallis-and-Futuna",
      "population": 10790,
      "cases": {
        "new": null,
        "active": 316,
        "critical": null,
        "recovered": 438,
        "1M_pop": "70528",
        "total": 761
      },
      "deaths": {
        "new": null,
        "1M_pop": "649",
        "total": 7
      },
      "tests": {
        "1M_pop": "1900649",
        "total": 20508
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Niue",
      "population": 1651,
      "cases": {
        "new": null,
        "active": 2,
        "critical": null,
        "recovered": 81,
        "1M_pop": "50273",
        "total": 83
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
    },
    {
      "continent": "Europe",
      "country": "Vatican-City",
      "population": 806,
      "cases": {
        "new": null,
        "active": 0,
        "critical": null,
        "recovered": 29,
        "1M_pop": "35980",
        "total": 29
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
    },
    {
      "continent": "Oceania",
      "country": "Tuvalu",
      "population": 12125,
      "cases": {
        "new": null,
        "active": 20,
        "critical": null,
        "recovered": null,
        "1M_pop": "1649",
        "total": 20
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
    },
    {
      "continent": "Asia",
      "country": "China",
      "population": 1439323776,
      "cases": {
        "new": "+245",
        "active": 4463,
        "critical": 16,
        "recovered": 246329,
        "1M_pop": "178",
        "total": 256018
      },
      "deaths": {
        "new": null,
        "1M_pop": "4",
        "total": 5226
      },
      "tests": {
        "1M_pop": "111163",
        "total": 160000000
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": null,
      "country": "Diamond-Princess",
      "population": null,
      "cases": {
        "new": null,
        "active": 0,
        "critical": null,
        "recovered": 699,
        "1M_pop": null,
        "total": 712
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": 13
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": null,
      "country": "MS-Zaandam",
      "population": null,
      "cases": {
        "new": null,
        "active": 0,
        "critical": null,
        "recovered": 7,
        "1M_pop": null,
        "total": 9
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": 2
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": "Africa",
      "country": "Western-Sahara",
      "population": 623634,
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:06+00:00"
    },
    {
      "continent": "Africa",
      "country": "Sudan",
      "population": 46190108,
      "cases": {
        "new": "+74",
        "active": 973,
        "critical": null,
        "recovered": 57512,
        "1M_pop": "1374",
        "total": 63449
      },
      "deaths": {
        "new": "+1",
        "1M_pop": "107",
        "total": 4964
      },
      "tests": {
        "1M_pop": "12187",
        "total": 562941
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Asia",
      "country": "Syria",
      "population": 18472706,
      "cases": {
        "new": "+3",
        "active": 16,
        "critical": null,
        "recovered": 54158,
        "1M_pop": "3104",
        "total": 57337
      },
      "deaths": {
        "new": null,
        "1M_pop": "171",
        "total": 3163
      },
      "tests": {
        "1M_pop": "7918",
        "total": 146269
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Mauritania",
      "population": 4929116,
      "cases": {
        "new": null,
        "active": 217,
        "critical": null,
        "recovered": 61898,
        "1M_pop": "12804",
        "total": 63110
      },
      "deaths": {
        "new": null,
        "1M_pop": "202",
        "total": 995
      },
      "tests": {
        "1M_pop": "199651",
        "total": 984105
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Cabo-Verde",
      "population": 569790,
      "cases": {
        "new": null,
        "active": 64,
        "critical": 23,
        "recovered": 61923,
        "1M_pop": "109509",
        "total": 62397
      },
      "deaths": {
        "new": null,
        "1M_pop": "720",
        "total": 410
      },
      "tests": {
        "1M_pop": "704860",
        "total": 401622
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Asia",
      "country": "Bhutan",
      "population": 791028,
      "cases": {
        "new": null,
        "active": 615,
        "critical": null,
        "recovered": 61564,
        "1M_pop": "78632",
        "total": 62200
      },
      "deaths": {
        "new": null,
        "1M_pop": "27",
        "total": 21
      },
      "tests": {
        "1M_pop": "2912329",
        "total": 2303734
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Burundi",
      "population": 12700628,
      "cases": {
        "new": null,
        "active": 147,
        "critical": null,
        "recovered": 50104,
        "1M_pop": "3960",
        "total": 50289
      },
      "deaths": {
        "new": null,
        "1M_pop": "3",
        "total": 38
      },
      "tests": {
        "1M_pop": "27222",
        "total": 345742
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Gabon",
      "population": 2345813,
      "cases": {
        "new": null,
        "active": 151,
        "critical": null,
        "recovered": 48353,
        "1M_pop": "20807",
        "total": 48810
      },
      "deaths": {
        "new": null,
        "1M_pop": "130",
        "total": 306
      },
      "tests": {
        "1M_pop": "689923",
        "total": 1618431
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Seychelles",
      "population": 99738,
      "cases": {
        "new": null,
        "active": 526,
        "critical": null,
        "recovered": 46446,
        "1M_pop": "472648",
        "total": 47141
      },
      "deaths": {
        "new": null,
        "1M_pop": "1694",
        "total": 169
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "Andorra",
      "population": 77547,
      "cases": {
        "new": null,
        "active": 124,
        "critical": 14,
        "recovered": 46087,
        "1M_pop": "597908",
        "total": 46366
      },
      "deaths": {
        "new": null,
        "1M_pop": "1999",
        "total": 155
      },
      "tests": {
        "1M_pop": "3221762",
        "total": 249838
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Papua-New-Guinea",
      "population": 9334490,
      "cases": {
        "new": null,
        "active": 549,
        "critical": 7,
        "recovered": 43982,
        "1M_pop": "4842",
        "total": 45199
      },
      "deaths": {
        "new": null,
        "1M_pop": "72",
        "total": 668
      },
      "tests": {
        "1M_pop": "26691",
        "total": 249149
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Cura&ccedil;ao",
      "population": 165626,
      "cases": {
        "new": null,
        "active": 125,
        "critical": 3,
        "recovered": 44720,
        "1M_pop": "272463",
        "total": 45127
      },
      "deaths": {
        "new": null,
        "1M_pop": "1703",
        "total": 282
      },
      "tests": {
        "1M_pop": "2998883",
        "total": 496693
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Aruba",
      "population": 107802,
      "cases": {
        "new": null,
        "active": 249,
        "critical": 2,
        "recovered": 42438,
        "1M_pop": "398082",
        "total": 42914
      },
      "deaths": {
        "new": null,
        "1M_pop": "2106",
        "total": 227
      },
      "tests": {
        "1M_pop": "1650109",
        "total": 177885
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Mauritius",
      "population": 1276589,
      "cases": {
        "new": null,
        "active": 624,
        "critical": null,
        "recovered": 38894,
        "1M_pop": "31763",
        "total": 40548
      },
      "deaths": {
        "new": null,
        "1M_pop": "807",
        "total": 1030
      },
      "tests": {
        "1M_pop": "280964",
        "total": 358675
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Mayotte",
      "population": 287865,
      "cases": {
        "new": null,
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "139986",
        "total": 40297
      },
      "deaths": {
        "new": null,
        "1M_pop": "650",
        "total": 187
      },
      "tests": {
        "1M_pop": "614590",
        "total": 176919
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Tanzania",
      "population": 63624887,
      "cases": {
        "new": null,
        "active": null,
        "critical": 7,
        "recovered": null,
        "1M_pop": "624",
        "total": 39679
      },
      "deaths": {
        "new": null,
        "1M_pop": "13",
        "total": 845
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "Isle-of-Man",
      "population": 86061,
      "cases": {
        "new": null,
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "441640",
        "total": 38008
      },
      "deaths": {
        "new": null,
        "1M_pop": "1348",
        "total": 116
      },
      "tests": {
        "1M_pop": "1751699",
        "total": 150753
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Guinea",
      "population": 13947338,
      "cases": {
        "new": null,
        "active": 461,
        "critical": 8,
        "recovered": 37034,
        "1M_pop": "2721",
        "total": 37950
      },
      "deaths": {
        "new": null,
        "1M_pop": "33",
        "total": 455
      },
      "tests": {
        "1M_pop": "47329",
        "total": 660107
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Bahamas",
      "population": 401832,
      "cases": {
        "new": null,
        "active": 275,
        "critical": 2,
        "recovered": 36226,
        "1M_pop": "92909",
        "total": 37334
      },
      "deaths": {
        "new": null,
        "1M_pop": "2073",
        "total": 833
      },
      "tests": {
        "1M_pop": "619279",
        "total": 248846
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "Faeroe-Islands",
      "population": 49287,
      "cases": {
        "new": null,
        "active": null,
        "critical": 5,
        "recovered": null,
        "1M_pop": "703187",
        "total": 34658
      },
      "deaths": {
        "new": null,
        "1M_pop": "568",
        "total": 28
      },
      "tests": {
        "1M_pop": "15785095",
        "total": 778000
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Lesotho",
      "population": 2181060,
      "cases": {
        "new": null,
        "active": 7804,
        "critical": null,
        "recovered": 25980,
        "1M_pop": "15813",
        "total": 34490
      },
      "deaths": {
        "new": null,
        "1M_pop": "324",
        "total": 706
      },
      "tests": {
        "1M_pop": "197712",
        "total": 431221
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Haiti",
      "population": 11720258,
      "cases": {
        "new": null,
        "active": 1473,
        "critical": null,
        "recovered": 31434,
        "1M_pop": "2881",
        "total": 33764
      },
      "deaths": {
        "new": null,
        "1M_pop": "73",
        "total": 857
      },
      "tests": {
        "1M_pop": "11299",
        "total": 132422
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Cayman-Islands",
      "population": 67486,
      "cases": {
        "new": null,
        "active": 22222,
        "critical": 1,
        "recovered": 8553,
        "1M_pop": "456524",
        "total": 30809
      },
      "deaths": {
        "new": null,
        "1M_pop": "504",
        "total": 34
      },
      "tests": {
        "1M_pop": "3301025",
        "total": 222773
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Saint-Lucia",
      "population": 185545,
      "cases": {
        "new": null,
        "active": 51,
        "critical": null,
        "recovered": 29095,
        "1M_pop": "159261",
        "total": 29550
      },
      "deaths": {
        "new": null,
        "1M_pop": "2177",
        "total": 404
      },
      "tests": {
        "1M_pop": "1137099",
        "total": 210983
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Benin",
      "population": 12849273,
      "cases": {
        "new": null,
        "active": 155,
        "critical": 5,
        "recovered": 27464,
        "1M_pop": "2162",
        "total": 27782
      },
      "deaths": {
        "new": null,
        "1M_pop": "13",
        "total": 163
      },
      "tests": {
        "1M_pop": "47031",
        "total": 604310
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Somalia",
      "population": 16907146,
      "cases": {
        "new": null,
        "active": 12680,
        "critical": null,
        "recovered": 13182,
        "1M_pop": "1610",
        "total": 27223
      },
      "deaths": {
        "new": null,
        "1M_pop": "80",
        "total": 1361
      },
      "tests": {
        "1M_pop": "23686",
        "total": 400466
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Congo",
      "population": 5828641,
      "cases": {
        "new": null,
        "active": 445,
        "critical": null,
        "recovered": 24006,
        "1M_pop": "4261",
        "total": 24837
      },
      "deaths": {
        "new": null,
        "1M_pop": "66",
        "total": 386
      },
      "tests": {
        "1M_pop": "59673",
        "total": 347815
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Asia",
      "country": "Timor-Leste",
      "population": 1375855,
      "cases": {
        "new": null,
        "active": 36,
        "critical": null,
        "recovered": 23102,
        "1M_pop": "16917",
        "total": 23276
      },
      "deaths": {
        "new": null,
        "1M_pop": "100",
        "total": 138
      },
      "tests": {
        "1M_pop": "202441",
        "total": 278529
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Burkina-Faso",
      "population": 22213940,
      "cases": {
        "new": null,
        "active": 101,
        "critical": null,
        "recovered": 21143,
        "1M_pop": "974",
        "total": 21631
      },
      "deaths": {
        "new": null,
        "1M_pop": "17",
        "total": 387
      },
      "tests": {
        "1M_pop": "11209",
        "total": 248995
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Solomon-Islands",
      "population": 725398,
      "cases": {
        "new": null,
        "active": 5034,
        "critical": 1,
        "recovered": 16357,
        "1M_pop": "29700",
        "total": 21544
      },
      "deaths": {
        "new": null,
        "1M_pop": "211",
        "total": 153
      },
      "tests": {
        "1M_pop": "7054",
        "total": 5117
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "San-Marino",
      "population": 34094,
      "cases": {
        "new": null,
        "active": 260,
        "critical": 4,
        "recovered": 20867,
        "1M_pop": "623130",
        "total": 21245
      },
      "deaths": {
        "new": null,
        "1M_pop": "3461",
        "total": 118
      },
      "tests": {
        "1M_pop": "4623511",
        "total": 157634
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "Gibraltar",
      "population": 33668,
      "cases": {
        "new": null,
        "active": 3434,
        "critical": null,
        "recovered": 16579,
        "1M_pop": "597630",
        "total": 20121
      },
      "deaths": {
        "new": null,
        "1M_pop": "3208",
        "total": 108
      },
      "tests": {
        "1M_pop": "15869164",
        "total": 534283
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Grenada",
      "population": 113714,
      "cases": {
        "new": null,
        "active": 51,
        "critical": 4,
        "recovered": 19248,
        "1M_pop": "171799",
        "total": 19536
      },
      "deaths": {
        "new": null,
        "1M_pop": "2084",
        "total": 237
      },
      "tests": {
        "1M_pop": "1581230",
        "total": 179808
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Nicaragua",
      "population": 6804707,
      "cases": {
        "new": null,
        "active": 14041,
        "critical": null,
        "recovered": 4225,
        "1M_pop": "2717",
        "total": 18491
      },
      "deaths": {
        "new": null,
        "1M_pop": "33",
        "total": 225
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Bermuda",
      "population": 61753,
      "cases": {
        "new": null,
        "active": 75,
        "critical": null,
        "recovered": 17997,
        "1M_pop": "295046",
        "total": 18220
      },
      "deaths": {
        "new": null,
        "1M_pop": "2397",
        "total": 148
      },
      "tests": {
        "1M_pop": "16339271",
        "total": 1008999
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "South-Sudan",
      "population": 11493697,
      "cases": {
        "new": null,
        "active": 350,
        "critical": 1,
        "recovered": 17335,
        "1M_pop": "1551",
        "total": 17823
      },
      "deaths": {
        "new": null,
        "1M_pop": "12",
        "total": 138
      },
      "tests": {
        "1M_pop": "35696",
        "total": 410280
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Asia",
      "country": "Tajikistan",
      "population": 10027435,
      "cases": {
        "new": null,
        "active": 397,
        "critical": null,
        "recovered": 17264,
        "1M_pop": "1774",
        "total": 17786
      },
      "deaths": {
        "new": null,
        "1M_pop": "12",
        "total": 125
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Equatorial-Guinea",
      "population": 1508399,
      "cases": {
        "new": null,
        "active": 185,
        "critical": 5,
        "recovered": 16713,
        "1M_pop": "11324",
        "total": 17081
      },
      "deaths": {
        "new": null,
        "1M_pop": "121",
        "total": 183
      },
      "tests": {
        "1M_pop": "242440",
        "total": 365697
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Tonga",
      "population": 108433,
      "cases": {
        "new": null,
        "active": 532,
        "critical": null,
        "recovered": 15638,
        "1M_pop": "149235",
        "total": 16182
      },
      "deaths": {
        "new": null,
        "1M_pop": "111",
        "total": 12
      },
      "tests": {
        "1M_pop": "4934005",
        "total": 535009
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Samoa",
      "population": 201427,
      "cases": {
        "new": null,
        "active": 14307,
        "critical": 4,
        "recovered": 1605,
        "1M_pop": "79140",
        "total": 15941
      },
      "deaths": {
        "new": null,
        "1M_pop": "144",
        "total": 29
      },
      "tests": {
        "1M_pop": "930347",
        "total": 187397
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Dominica",
      "population": 72394,
      "cases": {
        "new": null,
        "active": 13,
        "critical": null,
        "recovered": 15673,
        "1M_pop": "217698",
        "total": 15760
      },
      "deaths": {
        "new": null,
        "1M_pop": "1022",
        "total": 74
      },
      "tests": {
        "1M_pop": "3167997",
        "total": 229344
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Djibouti",
      "population": 1020843,
      "cases": {
        "new": null,
        "active": 74,
        "critical": null,
        "recovered": 15427,
        "1M_pop": "15370",
        "total": 15690
      },
      "deaths": {
        "new": null,
        "1M_pop": "185",
        "total": 189
      },
      "tests": {
        "1M_pop": "299694",
        "total": 305941
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Marshall-Islands",
      "population": 60103,
      "cases": {
        "new": null,
        "active": 166,
        "critical": 22,
        "recovered": 15192,
        "1M_pop": "255811",
        "total": 15375
      },
      "deaths": {
        "new": null,
        "1M_pop": "283",
        "total": 17
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "CAR",
      "population": 5021739,
      "cases": {
        "new": null,
        "active": 308,
        "critical": 2,
        "recovered": 14536,
        "1M_pop": "2978",
        "total": 14957
      },
      "deaths": {
        "new": null,
        "1M_pop": "23",
        "total": 113
      },
      "tests": {
        "1M_pop": "16188",
        "total": 81294
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "Monaco",
      "population": 39878,
      "cases": {
        "new": null,
        "active": 56,
        "critical": 4,
        "recovered": 14671,
        "1M_pop": "370881",
        "total": 14790
      },
      "deaths": {
        "new": null,
        "1M_pop": "1580",
        "total": 63
      },
      "tests": {
        "1M_pop": "1972165",
        "total": 78646
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Gambia",
      "population": 2571918,
      "cases": {
        "new": null,
        "active": 108,
        "critical": null,
        "recovered": 12028,
        "1M_pop": "4863",
        "total": 12508
      },
      "deaths": {
        "new": null,
        "1M_pop": "145",
        "total": 372
      },
      "tests": {
        "1M_pop": "60533",
        "total": 155686
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Saint-Martin",
      "population": 40173,
      "cases": {
        "new": null,
        "active": 10530,
        "critical": 7,
        "recovered": 1399,
        "1M_pop": "298509",
        "total": 11992
      },
      "deaths": {
        "new": null,
        "1M_pop": "1568",
        "total": 63
      },
      "tests": {
        "1M_pop": "2797451",
        "total": 112382
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Greenland",
      "population": 56995,
      "cases": {
        "new": null,
        "active": 9189,
        "critical": 4,
        "recovered": 2761,
        "1M_pop": "210036",
        "total": 11971
      },
      "deaths": {
        "new": null,
        "1M_pop": "368",
        "total": 21
      },
      "tests": {
        "1M_pop": "2893692",
        "total": 164926
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Asia",
      "country": "Yemen",
      "population": 31327851,
      "cases": {
        "new": null,
        "active": 657,
        "critical": 23,
        "recovered": 9124,
        "1M_pop": "381",
        "total": 11939
      },
      "deaths": {
        "new": null,
        "1M_pop": "69",
        "total": 2158
      },
      "tests": {
        "1M_pop": "10521",
        "total": 329592
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Vanuatu",
      "population": 323555,
      "cases": {
        "new": null,
        "active": 3,
        "critical": null,
        "recovered": 11918,
        "1M_pop": "36887",
        "total": 11935
      },
      "deaths": {
        "new": null,
        "1M_pop": "43",
        "total": 14
      },
      "tests": {
        "1M_pop": "77192",
        "total": 24976
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Caribbean-Netherlands",
      "population": 26780,
      "cases": {
        "new": null,
        "active": 772,
        "critical": null,
        "recovered": 10476,
        "1M_pop": "421359",
        "total": 11284
      },
      "deaths": {
        "new": null,
        "1M_pop": "1344",
        "total": 36
      },
      "tests": {
        "1M_pop": "1124944",
        "total": 30126
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Sint-Maarten",
      "population": 43989,
      "cases": {
        "new": null,
        "active": 10,
        "critical": null,
        "recovered": 10779,
        "1M_pop": "247244",
        "total": 10876
      },
      "deaths": {
        "new": null,
        "1M_pop": "1978",
        "total": 87
      },
      "tests": {
        "1M_pop": "1410716",
        "total": 62056
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Eritrea",
      "population": 3658620,
      "cases": {
        "new": null,
        "active": 7,
        "critical": null,
        "recovered": 10072,
        "1M_pop": "2783",
        "total": 10182
      },
      "deaths": {
        "new": null,
        "1M_pop": "28",
        "total": 103
      },
      "tests": {
        "1M_pop": "6476",
        "total": 23693
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Micronesia",
      "population": 117779,
      "cases": {
        "new": null,
        "active": 9878,
        "critical": 1,
        "recovered": 174,
        "1M_pop": "85609",
        "total": 10083
      },
      "deaths": {
        "new": null,
        "1M_pop": "263",
        "total": 31
      },
      "tests": {
        "1M_pop": "186137",
        "total": 21923
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Niger",
      "population": 26210825,
      "cases": {
        "new": null,
        "active": 729,
        "critical": 1,
        "recovered": 8890,
        "1M_pop": "379",
        "total": 9931
      },
      "deaths": {
        "new": null,
        "1M_pop": "12",
        "total": 312
      },
      "tests": {
        "1M_pop": "9711",
        "total": 254538
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Antigua-and-Barbuda",
      "population": 99782,
      "cases": {
        "new": null,
        "active": 6,
        "critical": 1,
        "recovered": 8954,
        "1M_pop": "91259",
        "total": 9106
      },
      "deaths": {
        "new": null,
        "1M_pop": "1463",
        "total": 146
      },
      "tests": {
        "1M_pop": "189423",
        "total": 18901
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Guinea-Bissau",
      "population": 2074351,
      "cases": {
        "new": null,
        "active": 345,
        "critical": 6,
        "recovered": 8310,
        "1M_pop": "4257",
        "total": 8831
      },
      "deaths": {
        "new": null,
        "1M_pop": "85",
        "total": 176
      },
      "tests": {
        "1M_pop": "70013",
        "total": 145231
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Comoros",
      "population": 911953,
      "cases": {
        "new": null,
        "active": 4,
        "critical": null,
        "recovered": 8316,
        "1M_pop": "9300",
        "total": 8481
      },
      "deaths": {
        "new": null,
        "1M_pop": "177",
        "total": 161
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Liberia",
      "population": 5329477,
      "cases": {
        "new": null,
        "active": 10,
        "critical": 2,
        "recovered": 7681,
        "1M_pop": "1498",
        "total": 7985
      },
      "deaths": {
        "new": null,
        "1M_pop": "55",
        "total": 294
      },
      "tests": {
        "1M_pop": "26236",
        "total": 139824
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Sierra-Leone",
      "population": 8347857,
      "cases": {
        "new": null,
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "929",
        "total": 7752
      },
      "deaths": {
        "new": null,
        "1M_pop": "15",
        "total": 126
      },
      "tests": {
        "1M_pop": "31141",
        "total": 259958
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Chad",
      "population": 17503679,
      "cases": {
        "new": null,
        "active": 2538,
        "critical": null,
        "recovered": 4874,
        "1M_pop": "434",
        "total": 7605
      },
      "deaths": {
        "new": null,
        "1M_pop": "11",
        "total": 193
      },
      "tests": {
        "1M_pop": "10931",
        "total": 191341
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "British-Virgin-Islands",
      "population": 30691,
      "cases": {
        "new": null,
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "238018",
        "total": 7305
      },
      "deaths": {
        "new": null,
        "1M_pop": "2085",
        "total": 64
      },
      "tests": {
        "1M_pop": "3497410",
        "total": 107339
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "St-Vincent-Grenadines",
      "population": 111745,
      "cases": {
        "new": null,
        "active": 356,
        "critical": null,
        "recovered": 6641,
        "1M_pop": "63645",
        "total": 7112
      },
      "deaths": {
        "new": null,
        "1M_pop": "1029",
        "total": 115
      },
      "tests": {
        "1M_pop": "902555",
        "total": 100856
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Saint-Kitts-and-Nevis",
      "population": 54059,
      "cases": {
        "new": null,
        "active": 13,
        "critical": null,
        "recovered": 6482,
        "1M_pop": "120997",
        "total": 6541
      },
      "deaths": {
        "new": null,
        "1M_pop": "851",
        "total": 46
      },
      "tests": {
        "1M_pop": "2309717",
        "total": 124861
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Cook-Islands",
      "population": 17601,
      "cases": {
        "new": null,
        "active": 4,
        "critical": null,
        "recovered": 6384,
        "1M_pop": "362991",
        "total": 6389
      },
      "deaths": {
        "new": null,
        "1M_pop": "57",
        "total": 1
      },
      "tests": {
        "1M_pop": "1118686",
        "total": 19690
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Turks-and-Caicos",
      "population": 39914,
      "cases": {
        "new": null,
        "active": 23,
        "critical": 4,
        "recovered": 6321,
        "1M_pop": "159844",
        "total": 6380
      },
      "deaths": {
        "new": null,
        "1M_pop": "902",
        "total": 36
      },
      "tests": {
        "1M_pop": "13781956",
        "total": 550093
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Sao-Tome-and-Principe",
      "population": 228463,
      "cases": {
        "new": null,
        "active": 16,
        "critical": null,
        "recovered": 6159,
        "1M_pop": "27365",
        "total": 6252
      },
      "deaths": {
        "new": null,
        "1M_pop": "337",
        "total": 77
      },
      "tests": {
        "1M_pop": "127093",
        "total": 29036
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Palau",
      "population": 18291,
      "cases": {
        "new": null,
        "active": 10,
        "critical": 1,
        "recovered": 5473,
        "1M_pop": "300148",
        "total": 5490
      },
      "deaths": {
        "new": null,
        "1M_pop": "383",
        "total": 7
      },
      "tests": {
        "1M_pop": "3581269",
        "total": 65505
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "St-Barth",
      "population": 9946,
      "cases": {
        "new": null,
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "533079",
        "total": 5302
      },
      "deaths": {
        "new": null,
        "1M_pop": "603",
        "total": 6
      },
      "tests": {
        "1M_pop": "7907299",
        "total": 78646
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Nauru",
      "population": 10980,
      "cases": {
        "new": null,
        "active": 5,
        "critical": null,
        "recovered": 4605,
        "1M_pop": "419945",
        "total": 4611
      },
      "deaths": {
        "new": null,
        "1M_pop": "91",
        "total": 1
      },
      "tests": {
        "1M_pop": "1867851",
        "total": 20509
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Anguilla",
      "population": 15309,
      "cases": {
        "new": null,
        "active": 5,
        "critical": 4,
        "recovered": 3849,
        "1M_pop": "252531",
        "total": 3866
      },
      "deaths": {
        "new": null,
        "1M_pop": "784",
        "total": 12
      },
      "tests": {
        "1M_pop": "3356326",
        "total": 51382
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Kiribati",
      "population": 123638,
      "cases": {
        "new": null,
        "active": 714,
        "critical": 3,
        "recovered": 2703,
        "1M_pop": "27742",
        "total": 3430
      },
      "deaths": {
        "new": null,
        "1M_pop": "105",
        "total": 13
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "North-America",
      "country": "Saint-Pierre-Miquelon",
      "population": 5729,
      "cases": {
        "new": null,
        "active": 781,
        "critical": 1,
        "recovered": 2449,
        "1M_pop": "563973",
        "total": 3231
      },
      "deaths": {
        "new": null,
        "1M_pop": "175",
        "total": 1
      },
      "tests": {
        "1M_pop": "4384709",
        "total": 25120
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "South-America",
      "country": "Falkland-Islands",
      "population": 3712,
      "cases": {
        "new": null,
        "active": 44,
        "critical": null,
        "recovered": 1886,
        "1M_pop": "519935",
        "total": 1930
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": null
      },
      "tests": {
        "1M_pop": "2325431",
        "total": 8632
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Europe",
      "country": "Liechtenstein",
      "population": 38378,
      "cases": {
        "new": "+2",
        "active": 350,
        "critical": 2,
        "recovered": 19953,
        "1M_pop": "531268",
        "total": 20389
      },
      "deaths": {
        "new": null,
        "1M_pop": "2241",
        "total": 86
      },
      "tests": {
        "1M_pop": "2662307",
        "total": 102174
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Togo",
      "population": 8722357,
      "cases": {
        "new": "+4",
        "active": 130,
        "critical": null,
        "recovered": 38839,
        "1M_pop": "4501",
        "total": 39256
      },
      "deaths": {
        "new": null,
        "1M_pop": "33",
        "total": 287
      },
      "tests": {
        "1M_pop": "91214",
        "total": 795598
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Africa",
      "country": "Mali",
      "population": 21584640,
      "cases": {
        "new": "+2",
        "active": 104,
        "critical": null,
        "recovered": 31865,
        "1M_pop": "1515",
        "total": 32711
      },
      "deaths": {
        "new": null,
        "1M_pop": "34",
        "total": 742
      },
      "tests": {
        "1M_pop": "35472",
        "total": 765644
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:05+00:00"
    },
    {
      "continent": "Asia",
      "country": "Kuwait",
      "population": 4414946,
      "cases": {
        "new": null,
        "active": 990,
        "critical": 1,
        "recovered": 657113,
        "1M_pop": "149643",
        "total": 660667
      },
      "deaths": {
        "new": null,
        "1M_pop": "581",
        "total": 2564
      },
      "tests": {
        "1M_pop": "1901053",
        "total": 8393046
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Dominican-Republic",
      "population": 11096544,
      "cases": {
        "new": null,
        "active": 250,
        "critical": 4,
        "recovered": 642571,
        "1M_pop": "58325",
        "total": 647205
      },
      "deaths": {
        "new": null,
        "1M_pop": "395",
        "total": 4384
      },
      "tests": {
        "1M_pop": "329567",
        "total": 3657057
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Myanmar",
      "population": 55243352,
      "cases": {
        "new": "+939",
        "active": 11209,
        "critical": null,
        "recovered": 597898,
        "1M_pop": "11378",
        "total": 628577
      },
      "deaths": {
        "new": "+1",
        "1M_pop": "352",
        "total": 19470
      },
      "tests": {
        "1M_pop": "163937",
        "total": 9056450
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Palestine",
      "population": 5372557,
      "cases": {
        "new": null,
        "active": 439,
        "critical": 17,
        "recovered": 614914,
        "1M_pop": "115542",
        "total": 620757
      },
      "deaths": {
        "new": null,
        "1M_pop": "1006",
        "total": 5404
      },
      "tests": {
        "1M_pop": "573011",
        "total": 3078533
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Estonia",
      "population": 1328573,
      "cases": {
        "new": null,
        "active": 76677,
        "critical": 7,
        "recovered": 524990,
        "1M_pop": "454909",
        "total": 604380
      },
      "deaths": {
        "new": null,
        "1M_pop": "2042",
        "total": 2713
      },
      "tests": {
        "1M_pop": "2674622",
        "total": 3553431
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Cyprus",
      "population": 1227445,
      "cases": {
        "new": null,
        "active": 8229,
        "critical": 60,
        "recovered": 584124,
        "1M_pop": "483559",
        "total": 593542
      },
      "deaths": {
        "new": null,
        "1M_pop": "969",
        "total": 1189
      },
      "tests": {
        "1M_pop": "7853809",
        "total": 9640118
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Moldova",
      "population": 4012551,
      "cases": {
        "new": null,
        "active": 75841,
        "critical": 49,
        "recovered": 504142,
        "1M_pop": "147500",
        "total": 591853
      },
      "deaths": {
        "new": null,
        "1M_pop": "2958",
        "total": 11870
      },
      "tests": {
        "1M_pop": "801561",
        "total": 3216305
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Venezuela",
      "population": 28251936,
      "cases": {
        "new": null,
        "active": 567,
        "critical": 36,
        "recovered": 538936,
        "1M_pop": "19302",
        "total": 545323
      },
      "deaths": {
        "new": null,
        "1M_pop": "206",
        "total": 5820
      },
      "tests": {
        "1M_pop": "118895",
        "total": 3359014
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Egypt",
      "population": 106747021,
      "cases": {
        "new": null,
        "active": 48850,
        "critical": 122,
        "recovered": 442182,
        "1M_pop": "4831",
        "total": 515645
      },
      "deaths": {
        "new": null,
        "1M_pop": "231",
        "total": 24613
      },
      "tests": {
        "1M_pop": "34599",
        "total": 3693367
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Ethiopia",
      "population": 121474729,
      "cases": {
        "new": null,
        "active": 14186,
        "critical": null,
        "recovered": 472025,
        "1M_pop": "4065",
        "total": 493783
      },
      "deaths": {
        "new": null,
        "1M_pop": "62",
        "total": 7572
      },
      "tests": {
        "1M_pop": "43542",
        "total": 5289299
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "R&eacute;union",
      "population": 909914,
      "cases": {
        "new": null,
        "active": 53560,
        "critical": 10,
        "recovered": 418572,
        "1M_pop": "519860",
        "total": 473028
      },
      "deaths": {
        "new": null,
        "1M_pop": "985",
        "total": 896
      },
      "tests": {
        "1M_pop": "1762430",
        "total": 1603660
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Honduras",
      "population": 10264723,
      "cases": {
        "new": null,
        "active": null,
        "critical": 105,
        "recovered": null,
        "1M_pop": "44489",
        "total": 456664
      },
      "deaths": {
        "new": null,
        "1M_pop": "1071",
        "total": 10996
      },
      "tests": {
        "1M_pop": "149394",
        "total": 1533488
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Armenia",
      "population": 2975896,
      "cases": {
        "new": null,
        "active": 2971,
        "critical": null,
        "recovered": 432811,
        "1M_pop": "149361",
        "total": 444482
      },
      "deaths": {
        "new": null,
        "1M_pop": "2923",
        "total": 8700
      },
      "tests": {
        "1M_pop": "1082035",
        "total": 3220025
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Oman",
      "population": 5403587,
      "cases": {
        "new": null,
        "active": 9495,
        "critical": 2,
        "recovered": 384669,
        "1M_pop": "73733",
        "total": 398424
      },
      "deaths": {
        "new": null,
        "1M_pop": "788",
        "total": 4260
      },
      "tests": {
        "1M_pop": "4626556",
        "total": 25000000
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Zambia",
      "population": 19561265,
      "cases": {
        "new": null,
        "active": 63,
        "critical": null,
        "recovered": 329544,
        "1M_pop": "17055",
        "total": 333624
      },
      "deaths": {
        "new": null,
        "1M_pop": "205",
        "total": 4017
      },
      "tests": {
        "1M_pop": "191194",
        "total": 3740005
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Botswana",
      "population": 2460182,
      "cases": {
        "new": null,
        "active": 599,
        "critical": 1,
        "recovered": 322955,
        "1M_pop": "132650",
        "total": 326344
      },
      "deaths": {
        "new": null,
        "1M_pop": "1134",
        "total": 2790
      },
      "tests": {
        "1M_pop": "823881",
        "total": 2026898
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Luxembourg",
      "population": 649259,
      "cases": {
        "new": null,
        "active": 7633,
        "critical": null,
        "recovered": 288991,
        "1M_pop": "458611",
        "total": 297757
      },
      "deaths": {
        "new": null,
        "1M_pop": "1745",
        "total": 1133
      },
      "tests": {
        "1M_pop": "6796312",
        "total": 4412567
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Nigeria",
      "population": 217821693,
      "cases": {
        "new": null,
        "active": 3523,
        "critical": 11,
        "recovered": 259259,
        "1M_pop": "1221",
        "total": 265937
      },
      "deaths": {
        "new": null,
        "1M_pop": "14",
        "total": 3155
      },
      "tests": {
        "1M_pop": "24980",
        "total": 5441162
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Zimbabwe",
      "population": 15357516,
      "cases": {
        "new": null,
        "active": 383,
        "critical": 12,
        "recovered": 251904,
        "1M_pop": "16793",
        "total": 257893
      },
      "deaths": {
        "new": null,
        "1M_pop": "365",
        "total": 5606
      },
      "tests": {
        "1M_pop": "164464",
        "total": 2525756
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Uzbekistan",
      "population": 34578019,
      "cases": {
        "new": null,
        "active": 1259,
        "critical": 23,
        "recovered": 241486,
        "1M_pop": "7068",
        "total": 244382
      },
      "deaths": {
        "new": null,
        "1M_pop": "47",
        "total": 1637
      },
      "tests": {
        "1M_pop": "39849",
        "total": 1377915
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Uruguay",
      "population": 3501236,
      "cases": {
        "new": "+964",
        "active": 920,
        "critical": 18,
        "recovered": 980097,
        "1M_pop": "282337",
        "total": 988527
      },
      "deaths": {
        "new": "+9",
        "1M_pop": "2145",
        "total": 7510
      },
      "tests": {
        "1M_pop": "1746475",
        "total": 6114822
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Brunei",
      "population": 447053,
      "cases": {
        "new": null,
        "active": 9468,
        "critical": 3,
        "recovered": 222140,
        "1M_pop": "518581",
        "total": 231833
      },
      "deaths": {
        "new": null,
        "1M_pop": "503",
        "total": 225
      },
      "tests": {
        "1M_pop": "1605590",
        "total": 717784
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Ivory-Coast",
      "population": 27871811,
      "cases": {
        "new": "+4",
        "active": 55,
        "critical": null,
        "recovered": 86720,
        "1M_pop": "3143",
        "total": 87602
      },
      "deaths": {
        "new": null,
        "1M_pop": "30",
        "total": 827
      },
      "tests": {
        "1M_pop": "58738",
        "total": 1637138
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Mozambique",
      "population": 33257805,
      "cases": {
        "new": null,
        "active": 0,
        "critical": 11,
        "recovered": 228146,
        "1M_pop": "6927",
        "total": 230370
      },
      "deaths": {
        "new": null,
        "1M_pop": "67",
        "total": 2224
      },
      "tests": {
        "1M_pop": "41227",
        "total": 1371127
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Guyana",
      "population": 795225,
      "cases": {
        "new": "+1",
        "active": 46,
        "critical": null,
        "recovered": 70077,
        "1M_pop": "89791",
        "total": 71404
      },
      "deaths": {
        "new": null,
        "1M_pop": "1611",
        "total": 1281
      },
      "tests": {
        "1M_pop": "879000",
        "total": 699003
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Martinique",
      "population": 374600,
      "cases": {
        "new": null,
        "active": null,
        "critical": 8,
        "recovered": null,
        "1M_pop": "594848",
        "total": 222830
      },
      "deaths": {
        "new": null,
        "1M_pop": "2795",
        "total": 1047
      },
      "tests": {
        "1M_pop": "2212835",
        "total": 828928
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Laos",
      "population": 7516898,
      "cases": {
        "new": "+3",
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "28749",
        "total": 216101
      },
      "deaths": {
        "new": null,
        "1M_pop": "101",
        "total": 758
      },
      "tests": {
        "1M_pop": "164058",
        "total": 1233207
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Kyrgyzstan",
      "population": 6770264,
      "cases": {
        "new": null,
        "active": 6853,
        "critical": 131,
        "recovered": 196406,
        "1M_pop": "30464",
        "total": 206250
      },
      "deaths": {
        "new": null,
        "1M_pop": "442",
        "total": 2991
      },
      "tests": {
        "1M_pop": "281702",
        "total": 1907195
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Iceland",
      "population": 346304,
      "cases": {
        "new": null,
        "active": null,
        "critical": 2,
        "recovered": null,
        "1M_pop": "594746",
        "total": 205963
      },
      "deaths": {
        "new": null,
        "1M_pop": "615",
        "total": 213
      },
      "tests": {
        "1M_pop": "5764831",
        "total": 1996384
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "El-Salvador",
      "population": 6560989,
      "cases": {
        "new": null,
        "active": 18145,
        "critical": 8,
        "recovered": 179410,
        "1M_pop": "30755",
        "total": 201785
      },
      "deaths": {
        "new": null,
        "1M_pop": "645",
        "total": 4230
      },
      "tests": {
        "1M_pop": "397823",
        "total": 2610114
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Azerbaijan",
      "population": 10348046,
      "cases": {
        "new": "+18",
        "active": 438,
        "critical": null,
        "recovered": 812247,
        "1M_pop": "79495",
        "total": 822617
      },
      "deaths": {
        "new": null,
        "1M_pop": "960",
        "total": 9932
      },
      "tests": {
        "1M_pop": "704539",
        "total": 7290601
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Guadeloupe",
      "population": 400280,
      "cases": {
        "new": null,
        "active": null,
        "critical": 19,
        "recovered": null,
        "1M_pop": "488640",
        "total": 195593
      },
      "deaths": {
        "new": null,
        "1M_pop": "2476",
        "total": 991
      },
      "tests": {
        "1M_pop": "2343457",
        "total": 938039
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Maldives",
      "population": 562309,
      "cases": {
        "new": null,
        "active": 21130,
        "critical": 25,
        "recovered": 163687,
        "1M_pop": "329223",
        "total": 185125
      },
      "deaths": {
        "new": null,
        "1M_pop": "548",
        "total": 308
      },
      "tests": {
        "1M_pop": "3937036",
        "total": 2213831
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Trinidad-and-Tobago",
      "population": 1409842,
      "cases": {
        "new": null,
        "active": 2945,
        "critical": 8,
        "recovered": 177081,
        "1M_pop": "130696",
        "total": 184261
      },
      "deaths": {
        "new": null,
        "1M_pop": "3004",
        "total": 4235
      },
      "tests": {
        "1M_pop": "597738",
        "total": 842716
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Ghana",
      "population": 32555858,
      "cases": {
        "new": null,
        "active": 464,
        "critical": 2,
        "recovered": 168397,
        "1M_pop": "5232",
        "total": 170321
      },
      "deaths": {
        "new": null,
        "1M_pop": "45",
        "total": 1460
      },
      "tests": {
        "1M_pop": "77149",
        "total": 2511658
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Uganda",
      "population": 49044537,
      "cases": {
        "new": null,
        "active": 65337,
        "critical": 3,
        "recovered": 100431,
        "1M_pop": "3454",
        "total": 169396
      },
      "deaths": {
        "new": null,
        "1M_pop": "74",
        "total": 3628
      },
      "tests": {
        "1M_pop": "61422",
        "total": 3012408
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Namibia",
      "population": 2646103,
      "cases": {
        "new": null,
        "active": 375,
        "critical": null,
        "recovered": 164813,
        "1M_pop": "63963",
        "total": 169253
      },
      "deaths": {
        "new": null,
        "1M_pop": "1536",
        "total": 4065
      },
      "tests": {
        "1M_pop": "401595",
        "total": 1062663
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Jamaica",
      "population": 2990699,
      "cases": {
        "new": null,
        "active": 49219,
        "critical": null,
        "recovered": 99392,
        "1M_pop": "50801",
        "total": 151931
      },
      "deaths": {
        "new": null,
        "1M_pop": "1110",
        "total": 3320
      },
      "tests": {
        "1M_pop": "395889",
        "total": 1183986
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Cambodia",
      "population": 17247880,
      "cases": {
        "new": "+5",
        "active": 70,
        "critical": null,
        "recovered": 134844,
        "1M_pop": "7999",
        "total": 137970
      },
      "deaths": {
        "new": null,
        "1M_pop": "177",
        "total": 3056
      },
      "tests": {
        "1M_pop": "178108",
        "total": 3071982
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Rwanda",
      "population": 13686339,
      "cases": {
        "new": null,
        "active": 34,
        "critical": null,
        "recovered": 131027,
        "1M_pop": "9683",
        "total": 132528
      },
      "deaths": {
        "new": null,
        "1M_pop": "107",
        "total": 1467
      },
      "tests": {
        "1M_pop": "426777",
        "total": 5841019
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Cameroon",
      "population": 28056749,
      "cases": {
        "new": null,
        "active": 1101,
        "critical": 13,
        "recovered": 118616,
        "1M_pop": "4336",
        "total": 121652
      },
      "deaths": {
        "new": null,
        "1M_pop": "69",
        "total": 1935
      },
      "tests": {
        "1M_pop": "62437",
        "total": 1751774
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Angola",
      "population": 35204279,
      "cases": {
        "new": null,
        "active": 59,
        "critical": null,
        "recovered": 101155,
        "1M_pop": "2930",
        "total": 103131
      },
      "deaths": {
        "new": null,
        "1M_pop": "54",
        "total": 1917
      },
      "tests": {
        "1M_pop": "42603",
        "total": 1499795
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Barbados",
      "population": 288179,
      "cases": {
        "new": null,
        "active": 430,
        "critical": null,
        "recovered": 102024,
        "1M_pop": "357465",
        "total": 103014
      },
      "deaths": {
        "new": null,
        "1M_pop": "1943",
        "total": 560
      },
      "tests": {
        "1M_pop": "2672297",
        "total": 770100
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "French-Guiana",
      "population": 316384,
      "cases": {
        "new": null,
        "active": 82409,
        "critical": 3,
        "recovered": 11254,
        "1M_pop": "297338",
        "total": 94073
      },
      "deaths": {
        "new": null,
        "1M_pop": "1296",
        "total": 410
      },
      "tests": {
        "1M_pop": "2058438",
        "total": 651257
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "DRC",
      "population": 95788051,
      "cases": {
        "new": null,
        "active": 8006,
        "critical": null,
        "recovered": 83522,
        "1M_pop": "971",
        "total": 92972
      },
      "deaths": {
        "new": null,
        "1M_pop": "15",
        "total": 1444
      },
      "tests": {
        "1M_pop": "8839",
        "total": 846704
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Channel-Islands",
      "population": 177526,
      "cases": {
        "new": null,
        "active": 860,
        "critical": null,
        "recovered": 91820,
        "1M_pop": "523214",
        "total": 92884
      },
      "deaths": {
        "new": null,
        "1M_pop": "1149",
        "total": 204
      },
      "tests": {
        "1M_pop": "7057040",
        "total": 1252808
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Senegal",
      "population": 17752853,
      "cases": {
        "new": null,
        "active": 101,
        "critical": null,
        "recovered": 86486,
        "1M_pop": "4988",
        "total": 88555
      },
      "deaths": {
        "new": null,
        "1M_pop": "111",
        "total": 1968
      },
      "tests": {
        "1M_pop": "64584",
        "total": 1146543
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Malawi",
      "population": 20260246,
      "cases": {
        "new": null,
        "active": 402,
        "critical": 67,
        "recovered": 84973,
        "1M_pop": "4346",
        "total": 88057
      },
      "deaths": {
        "new": null,
        "1M_pop": "132",
        "total": 2682
      },
      "tests": {
        "1M_pop": "30535",
        "total": 618640
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Suriname",
      "population": 598645,
      "cases": {
        "new": null,
        "active": null,
        "critical": null,
        "recovered": null,
        "1M_pop": "135524",
        "total": 81131
      },
      "deaths": {
        "new": null,
        "1M_pop": "2314",
        "total": 1385
      },
      "tests": {
        "1M_pop": "399703",
        "total": 239280
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Oceania",
      "country": "French-Polynesia",
      "population": 284619,
      "cases": {
        "new": null,
        "active": null,
        "critical": 7,
        "recovered": null,
        "1M_pop": "269504",
        "total": 76706
      },
      "deaths": {
        "new": null,
        "1M_pop": "2280",
        "total": 649
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Oceania",
      "country": "New-Caledonia",
      "population": 291771,
      "cases": {
        "new": null,
        "active": 12,
        "critical": 9,
        "recovered": 73884,
        "1M_pop": "254343",
        "total": 74210
      },
      "deaths": {
        "new": null,
        "1M_pop": "1076",
        "total": 314
      },
      "tests": {
        "1M_pop": "339184",
        "total": 98964
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Eswatini",
      "population": 1187620,
      "cases": {
        "new": null,
        "active": 41,
        "critical": null,
        "recovered": 71973,
        "1M_pop": "61835",
        "total": 73436
      },
      "deaths": {
        "new": null,
        "1M_pop": "1197",
        "total": 1422
      },
      "tests": {
        "1M_pop": "880671",
        "total": 1045903
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Belize",
      "population": 414130,
      "cases": {
        "new": null,
        "active": 26,
        "critical": 6,
        "recovered": 68197,
        "1M_pop": "166395",
        "total": 68909
      },
      "deaths": {
        "new": null,
        "1M_pop": "1656",
        "total": 686
      },
      "tests": {
        "1M_pop": "1390906",
        "total": 576016
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Fiji",
      "population": 911290,
      "cases": {
        "new": null,
        "active": 1063,
        "critical": null,
        "recovered": 66307,
        "1M_pop": "74892",
        "total": 68248
      },
      "deaths": {
        "new": null,
        "1M_pop": "963",
        "total": 878
      },
      "tests": {
        "1M_pop": "727925",
        "total": 663351
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Madagascar",
      "population": 29318753,
      "cases": {
        "new": null,
        "active": 10,
        "critical": null,
        "recovered": 65267,
        "1M_pop": "2275",
        "total": 66687
      },
      "deaths": {
        "new": null,
        "1M_pop": "48",
        "total": 1410
      },
      "tests": {
        "1M_pop": "17497",
        "total": 512993
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Latvia",
      "population": 1838606,
      "cases": {
        "new": "+1379",
        "active": 11787,
        "critical": 3,
        "recovered": 926487,
        "1M_pop": "513597",
        "total": 944302
      },
      "deaths": {
        "new": null,
        "1M_pop": "3279",
        "total": 6028
      },
      "tests": {
        "1M_pop": "4190276",
        "total": 7704267
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Malta",
      "population": 444230,
      "cases": {
        "new": "+23",
        "active": 716,
        "critical": 4,
        "recovered": 113514,
        "1M_pop": "258956",
        "total": 115036
      },
      "deaths": {
        "new": null,
        "1M_pop": "1814",
        "total": 806
      },
      "tests": {
        "1M_pop": "4660104",
        "total": 2070158
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Qatar",
      "population": 2807805,
      "cases": {
        "new": "+736",
        "active": 2543,
        "critical": null,
        "recovered": 459490,
        "1M_pop": "164796",
        "total": 462716
      },
      "deaths": {
        "new": null,
        "1M_pop": "243",
        "total": 683
      },
      "tests": {
        "1M_pop": "1425627",
        "total": 4002884
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Nepal",
      "population": 30334870,
      "cases": {
        "new": "+40",
        "active": 711,
        "critical": null,
        "recovered": 987462,
        "1M_pop": "32972",
        "total": 1000191
      },
      "deaths": {
        "new": null,
        "1M_pop": "396",
        "total": 12018
      },
      "tests": {
        "1M_pop": "196122",
        "total": 5949326
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Libya",
      "population": 7084878,
      "cases": {
        "new": null,
        "active": 47,
        "critical": 101,
        "recovered": 500528,
        "1M_pop": "71563",
        "total": 507012
      },
      "deaths": {
        "new": null,
        "1M_pop": "909",
        "total": 6437
      },
      "tests": {
        "1M_pop": "350393",
        "total": 2482490
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Afghanistan",
      "population": 40932825,
      "cases": {
        "new": "+40",
        "active": 13685,
        "critical": 1124,
        "recovered": 179780,
        "1M_pop": "4917",
        "total": 201276
      },
      "deaths": {
        "new": null,
        "1M_pop": "191",
        "total": 7811
      },
      "tests": {
        "1M_pop": "27383",
        "total": 1120863
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "UAE",
      "population": 10163546,
      "cases": {
        "new": "+314",
        "active": 18754,
        "critical": null,
        "recovered": 1012057,
        "1M_pop": "101653",
        "total": 1033158
      },
      "deaths": {
        "new": "+1",
        "1M_pop": "231",
        "total": 2347
      },
      "tests": {
        "1M_pop": "18997141",
        "total": 193078317
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Saudi-Arabia",
      "population": 36053288,
      "cases": {
        "new": "+246",
        "active": 4030,
        "critical": 34,
        "recovered": 805670,
        "1M_pop": "22719",
        "total": 819083
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "260",
        "total": 9383
      },
      "tests": {
        "1M_pop": "1232976",
        "total": 44452841
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Bosnia-and-Herzegovina",
      "population": 3234227,
      "cases": {
        "new": "+89",
        "active": 6140,
        "critical": null,
        "recovered": 377199,
        "1M_pop": "123522",
        "total": 399499
      },
      "deaths": {
        "new": "+4",
        "1M_pop": "4997",
        "total": 16160
      },
      "tests": {
        "1M_pop": "577758",
        "total": 1868599
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Cuba",
      "population": 11310824,
      "cases": {
        "new": "+2",
        "active": 76,
        "critical": 23,
        "recovered": 1102654,
        "1M_pop": "98247",
        "total": 1111260
      },
      "deaths": {
        "new": null,
        "1M_pop": "754",
        "total": 8530
      },
      "tests": {
        "1M_pop": "1252494",
        "total": 14166734
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Sri-Lanka",
      "population": 21618397,
      "cases": {
        "new": "+8",
        "active": 35,
        "critical": null,
        "recovered": 654125,
        "1M_pop": "31035",
        "total": 670929
      },
      "deaths": {
        "new": null,
        "1M_pop": "776",
        "total": 16769
      },
      "tests": {
        "1M_pop": "300028",
        "total": 6486117
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "North-Macedonia",
      "population": 2083179,
      "cases": {
        "new": "+80",
        "active": 288,
        "critical": null,
        "recovered": 333824,
        "1M_pop": "164971",
        "total": 343665
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "4586",
        "total": 9553
      },
      "tests": {
        "1M_pop": "1025486",
        "total": 2136270
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Montenegro",
      "population": 628248,
      "cases": {
        "new": "+55",
        "active": 821,
        "critical": 6,
        "recovered": 278285,
        "1M_pop": "448692",
        "total": 281890
      },
      "deaths": {
        "new": null,
        "1M_pop": "4431",
        "total": 2784
      },
      "tests": {
        "1M_pop": "4200642",
        "total": 2639045
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Bahrain",
      "population": 1836850,
      "cases": {
        "new": "+367",
        "active": 2436,
        "critical": 1,
        "recovered": 682010,
        "1M_pop": "373449",
        "total": 685969
      },
      "deaths": {
        "new": null,
        "1M_pop": "829",
        "total": 1523
      },
      "tests": {
        "1M_pop": "5685531",
        "total": 10443468
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Albania",
      "population": 2870620,
      "cases": {
        "new": "+7",
        "active": 1598,
        "critical": null,
        "recovered": 327456,
        "1M_pop": "115879",
        "total": 332645
      },
      "deaths": {
        "new": null,
        "1M_pop": "1251",
        "total": 3591
      },
      "tests": {
        "1M_pop": "676172",
        "total": 1941032
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Bolivia",
      "population": 12037000,
      "cases": {
        "new": "+18",
        "active": 25554,
        "critical": 220,
        "recovered": 1061205,
        "1M_pop": "92132",
        "total": 1108996
      },
      "deaths": {
        "new": null,
        "1M_pop": "1847",
        "total": 22237
      },
      "tests": {
        "1M_pop": "224759",
        "total": 2705422
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Ecuador",
      "population": 18255486,
      "cases": {
        "new": null,
        "active": 1764,
        "critical": 759,
        "recovered": 969254,
        "1M_pop": "55157",
        "total": 1006922
      },
      "deaths": {
        "new": null,
        "1M_pop": "1967",
        "total": 35904
      },
      "tests": {
        "1M_pop": "168848",
        "total": 3082403
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Belarus",
      "population": 9442223,
      "cases": {
        "new": null,
        "active": 1327,
        "critical": null,
        "recovered": 985592,
        "1M_pop": "105276",
        "total": 994037
      },
      "deaths": {
        "new": null,
        "1M_pop": "754",
        "total": 7118
      },
      "tests": {
        "1M_pop": "1445278",
        "total": 13646641
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "North-America",
      "country": "Panama",
      "population": 4470039,
      "cases": {
        "new": null,
        "active": 872,
        "critical": 16,
        "recovered": 978903,
        "1M_pop": "221090",
        "total": 988280
      },
      "deaths": {
        "new": null,
        "1M_pop": "1903",
        "total": 8505
      },
      "tests": {
        "1M_pop": "1589407",
        "total": 7104713
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Kenya",
      "population": 56479317,
      "cases": {
        "new": "+21",
        "active": 84,
        "critical": 1,
        "recovered": 332837,
        "1M_pop": "5995",
        "total": 338599
      },
      "deaths": {
        "new": null,
        "1M_pop": "101",
        "total": 5678
      },
      "tests": {
        "1M_pop": "69159",
        "total": 3906063
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Asia",
      "country": "Mongolia",
      "population": 3398977,
      "cases": {
        "new": null,
        "active": 1094,
        "critical": 192,
        "recovered": 980685,
        "1M_pop": "289487",
        "total": 983958
      },
      "deaths": {
        "new": null,
        "1M_pop": "641",
        "total": 2179
      },
      "tests": {
        "1M_pop": "1185665",
        "total": 4030048
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Africa",
      "country": "Algeria",
      "population": 45661296,
      "cases": {
        "new": "+17",
        "active": 81509,
        "critical": null,
        "recovered": 182367,
        "1M_pop": "5930",
        "total": 270757
      },
      "deaths": {
        "new": null,
        "1M_pop": "151",
        "total": 6881
      },
      "tests": {
        "1M_pop": "5056",
        "total": 230861
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "South-America",
      "country": "Paraguay",
      "population": 7332803,
      "cases": {
        "new": null,
        "active": 303,
        "critical": 7,
        "recovered": 697361,
        "1M_pop": "97815",
        "total": 717260
      },
      "deaths": {
        "new": null,
        "1M_pop": "2672",
        "total": 19596
      },
      "tests": {
        "1M_pop": "362413",
        "total": 2657506
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:04+00:00"
    },
    {
      "continent": "Europe",
      "country": "Bulgaria",
      "population": 6829035,
      "cases": {
        "new": "+1147",
        "active": 10408,
        "critical": 54,
        "recovered": 1223025,
        "1M_pop": "186150",
        "total": 1271228
      },
      "deaths": {
        "new": "+11",
        "1M_pop": "5534",
        "total": 37795
      },
      "tests": {
        "1M_pop": "1558580",
        "total": 10643594
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Africa",
      "country": "Africa",
      "population": null,
      "cases": {
        "new": "+508",
        "active": 404116,
        "critical": 1000,
        "recovered": 11998054,
        "1M_pop": null,
        "total": 12659912
      },
      "deaths": {
        "new": "+1",
        "1M_pop": null,
        "total": 257742
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Iran",
      "population": 86450371,
      "cases": {
        "new": "+370",
        "active": 80836,
        "critical": 124,
        "recovered": 7329344,
        "1M_pop": "87388",
        "total": 7554703
      },
      "deaths": {
        "new": "+4",
        "1M_pop": "1672",
        "total": 144523
      },
      "tests": {
        "1M_pop": "625741",
        "total": 54095556
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Croatia",
      "population": 4047466,
      "cases": {
        "new": "+27",
        "active": 3533,
        "critical": 22,
        "recovered": 1221226,
        "1M_pop": "306807",
        "total": 1241791
      },
      "deaths": {
        "new": "+9",
        "1M_pop": "4208",
        "total": 17032
      },
      "tests": {
        "1M_pop": "1313182",
        "total": 5315060
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "North-America",
      "country": "Guatemala",
      "population": 18673219,
      "cases": {
        "new": "+96",
        "active": 1623,
        "critical": 5,
        "recovered": 1112040,
        "1M_pop": "60703",
        "total": 1133517
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "1063",
        "total": 19854
      },
      "tests": {
        "1M_pop": "322354",
        "total": 6019393
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Asia",
      "population": null,
      "cases": {
        "new": "+75229",
        "active": 4494218,
        "critical": 9530,
        "recovered": 185925921,
        "1M_pop": null,
        "total": 191904342
      },
      "deaths": {
        "new": "+159",
        "1M_pop": null,
        "total": 1484203
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Europe",
      "population": null,
      "cases": {
        "new": "+48481",
        "active": 5581843,
        "critical": 10056,
        "recovered": 224008508,
        "1M_pop": null,
        "total": 231521014
      },
      "deaths": {
        "new": "+373",
        "1M_pop": null,
        "total": 1930663
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "South-America",
      "country": "South-America",
      "population": null,
      "cases": {
        "new": "+8232",
        "active": 359868,
        "critical": 10165,
        "recovered": 62577009,
        "1M_pop": null,
        "total": 64268411
      },
      "deaths": {
        "new": "+120",
        "1M_pop": null,
        "total": 1331534
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "South-America",
      "country": "Brazil",
      "population": 216012413,
      "cases": {
        "new": "+3826",
        "active": 155486,
        "critical": 8318,
        "recovered": 33953433,
        "1M_pop": "161084",
        "total": 34796212
      },
      "deaths": {
        "new": "+96",
        "1M_pop": "3182",
        "total": 687293
      },
      "tests": {
        "1M_pop": "295243",
        "total": 63776166
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Norway",
      "population": 5518120,
      "cases": {
        "new": "+107",
        "active": 1134,
        "critical": 20,
        "recovered": 1458284,
        "1M_pop": "265230",
        "total": 1463571
      },
      "deaths": {
        "new": null,
        "1M_pop": "753",
        "total": 4153
      },
      "tests": {
        "1M_pop": "1993873",
        "total": 11002430
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "North-America",
      "country": "North-America",
      "population": null,
      "cases": {
        "new": "+8638",
        "active": 3166203,
        "critical": 7748,
        "recovered": 112531143,
        "1M_pop": null,
        "total": 117244315
      },
      "deaths": {
        "new": "+51",
        "1M_pop": null,
        "total": 1546969
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "All",
      "country": "All",
      "population": null,
      "cases": {
        "new": "+143929",
        "active": 14172873,
        "critical": 38591,
        "recovered": 609355022,
        "1M_pop": "80836",
        "total": 630100337
      },
      "deaths": {
        "new": "+709",
        "1M_pop": "843.2",
        "total": 6572442
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "North-America",
      "country": "USA",
      "population": 335150851,
      "cases": {
        "new": "+8540",
        "active": 1572707,
        "critical": 2564,
        "recovered": 96203934,
        "1M_pop": "294994",
        "total": 98867370
      },
      "deaths": {
        "new": "+49",
        "1M_pop": "3254",
        "total": 1090729
      },
      "tests": {
        "1M_pop": "3353811",
        "total": 1124032521
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Oceania",
      "population": null,
      "cases": {
        "new": "+2841",
        "active": 166625,
        "critical": 92,
        "recovered": 12313681,
        "1M_pop": null,
        "total": 12501622
      },
      "deaths": {
        "new": "+5",
        "1M_pop": null,
        "total": 21316
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Japan",
      "population": 125592241,
      "cases": {
        "new": "+15372",
        "active": 1273761,
        "critical": 118,
        "recovered": 20453316,
        "1M_pop": "173362",
        "total": 21772967
      },
      "deaths": {
        "new": "+20",
        "1M_pop": "365",
        "total": 45890
      },
      "tests": {
        "1M_pop": "606737",
        "total": 76201407
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Russia",
      "population": 146077407,
      "cases": {
        "new": "+10403",
        "active": 307606,
        "critical": 2300,
        "recovered": 20618358,
        "1M_pop": "145915",
        "total": 21314957
      },
      "deaths": {
        "new": "+92",
        "1M_pop": "2663",
        "total": 388993
      },
      "tests": {
        "1M_pop": "1871610",
        "total": 273400000
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Slovakia",
      "population": 5465683,
      "cases": {
        "new": "+75",
        "active": 5142,
        "critical": 42,
        "recovered": 1823942,
        "1M_pop": "338403",
        "total": 1849602
      },
      "deaths": {
        "new": "+7",
        "1M_pop": "3754",
        "total": 20518
      },
      "tests": {
        "1M_pop": "1339026",
        "total": 7318689
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Poland",
      "population": 37751933,
      "cases": {
        "new": "+285",
        "active": 873193,
        "critical": 3650,
        "recovered": 5335940,
        "1M_pop": "167595",
        "total": 6327033
      },
      "deaths": {
        "new": null,
        "1M_pop": "3123",
        "total": 117900
      },
      "tests": {
        "1M_pop": "994047",
        "total": 37527211
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Slovenia",
      "population": 2079591,
      "cases": {
        "new": "+556",
        "active": 28543,
        "critical": 27,
        "recovered": 1180878,
        "1M_pop": "584863",
        "total": 1216276
      },
      "deaths": {
        "new": "+3",
        "1M_pop": "3296",
        "total": 6855
      },
      "tests": {
        "1M_pop": "1325461",
        "total": 2756417
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Vietnam",
      "population": 99340246,
      "cases": {
        "new": "+673",
        "active": 850913,
        "critical": 92,
        "recovered": 10599201,
        "1M_pop": "115696",
        "total": 11493271
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "434",
        "total": 43157
      },
      "tests": {
        "1M_pop": "863966",
        "total": 85826548
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Indonesia",
      "population": 280134469,
      "cases": {
        "new": "+1233",
        "active": 16823,
        "critical": 2771,
        "recovered": 6282951,
        "1M_pop": "23054",
        "total": 6458101
      },
      "deaths": {
        "new": "+14",
        "1M_pop": "565",
        "total": 158327
      },
      "tests": {
        "1M_pop": "391499",
        "total": 109672450
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Philippines",
      "population": 112915001,
      "cases": {
        "new": "+1938",
        "active": 25848,
        "critical": 646,
        "recovered": 3895420,
        "1M_pop": "35290",
        "total": 3984815
      },
      "deaths": {
        "new": "+37",
        "1M_pop": "563",
        "total": 63547
      },
      "tests": {
        "1M_pop": "293077",
        "total": 33092842
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Ireland",
      "population": 5063857,
      "cases": {
        "new": null,
        "active": 6901,
        "critical": 16,
        "recovered": 1653448,
        "1M_pop": "329453",
        "total": 1668301
      },
      "deaths": {
        "new": null,
        "1M_pop": "1570",
        "total": 7952
      },
      "tests": {
        "1M_pop": "2517705",
        "total": 12749296
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Germany",
      "population": 84396040,
      "cases": {
        "new": null,
        "active": 1520715,
        "critical": 1406,
        "recovered": 32936700,
        "1M_pop": "410077",
        "total": 34608835
      },
      "deaths": {
        "new": null,
        "1M_pop": "1794",
        "total": 151420
      },
      "tests": {
        "1M_pop": "1449504",
        "total": 122332384
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "S-Korea",
      "population": 51369980,
      "cases": {
        "new": "+11040",
        "active": 390859,
        "critical": 248,
        "recovered": 24711795,
        "1M_pop": "489226",
        "total": 25131505
      },
      "deaths": {
        "new": "+11",
        "1M_pop": "562",
        "total": 28851
      },
      "tests": {
        "1M_pop": "307652",
        "total": 15804065
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "UK",
      "population": 68700880,
      "cases": {
        "new": null,
        "active": 186164,
        "critical": 146,
        "recovered": 23420948,
        "1M_pop": "346412",
        "total": 23798793
      },
      "deaths": {
        "new": null,
        "1M_pop": "2790",
        "total": 191681
      },
      "tests": {
        "1M_pop": "7605819",
        "total": 522526476
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Hong-Kong",
      "population": 7635986,
      "cases": {
        "new": "+5361",
        "active": 191230,
        "critical": 11,
        "recovered": 1641701,
        "1M_pop": "241385",
        "total": 1843209
      },
      "deaths": {
        "new": "+5",
        "1M_pop": "1346",
        "total": 10278
      },
      "tests": {
        "1M_pop": "8680577",
        "total": 66284763
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Turkey",
      "population": 86413372,
      "cases": {
        "new": null,
        "active": 9908,
        "critical": null,
        "recovered": 16808527,
        "1M_pop": "195799",
        "total": 16919638
      },
      "deaths": {
        "new": null,
        "1M_pop": "1171",
        "total": 101203
      },
      "tests": {
        "1M_pop": "1883312",
        "total": 162743369
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Spain",
      "population": 46796147,
      "cases": {
        "new": null,
        "active": 90095,
        "critical": 339,
        "recovered": 13257857,
        "1M_pop": "287686",
        "total": 13462593
      },
      "deaths": {
        "new": null,
        "1M_pop": "2450",
        "total": 114641
      },
      "tests": {
        "1M_pop": "10065708",
        "total": 471036328
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Oceania",
      "country": "Australia",
      "population": 26176156,
      "cases": {
        "new": "+800",
        "active": 78150,
        "critical": 37,
        "recovered": 10216900,
        "1M_pop": "393890",
        "total": 10310525
      },
      "deaths": {
        "new": null,
        "1M_pop": "591",
        "total": 15475
      },
      "tests": {
        "1M_pop": "3011712",
        "total": 78835048
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "South-America",
      "country": "Argentina",
      "population": 46143638,
      "cases": {
        "new": null,
        "active": 7674,
        "critical": 259,
        "recovered": 9577820,
        "1M_pop": "210548",
        "total": 9715464
      },
      "deaths": {
        "new": null,
        "1M_pop": "2817",
        "total": 129970
      },
      "tests": {
        "1M_pop": "774019",
        "total": 35716069
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Netherlands",
      "population": 17221490,
      "cases": {
        "new": null,
        "active": 70482,
        "critical": 39,
        "recovered": 8382859,
        "1M_pop": "492179",
        "total": 8476062
      },
      "deaths": {
        "new": null,
        "1M_pop": "1319",
        "total": 22721
      },
      "tests": {
        "1M_pop": "1225643",
        "total": 21107399
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Denmark",
      "population": 5838806,
      "cases": {
        "new": "+2495",
        "active": 13641,
        "critical": 3,
        "recovered": 3106765,
        "1M_pop": "535658",
        "total": 3127601
      },
      "deaths": {
        "new": "+22",
        "1M_pop": "1232",
        "total": 7195
      },
      "tests": {
        "1M_pop": "22015045",
        "total": 128541575
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Taiwan",
      "population": 23915257,
      "cases": {
        "new": "+28847",
        "active": 888177,
        "critical": null,
        "recovered": 6312600,
        "1M_pop": "301596",
        "total": 7212738
      },
      "deaths": {
        "new": "+53",
        "1M_pop": "500",
        "total": 11961
      },
      "tests": {
        "1M_pop": "1132052",
        "total": 27073308
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "North-America",
      "country": "Mexico",
      "population": 132028927,
      "cases": {
        "new": null,
        "active": 397532,
        "critical": 4798,
        "recovered": 6375138,
        "1M_pop": "53798",
        "total": 7102947
      },
      "deaths": {
        "new": null,
        "1M_pop": "2502",
        "total": 330277
      },
      "tests": {
        "1M_pop": "140298",
        "total": 18523417
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "South-America",
      "country": "Colombia",
      "population": 52122496,
      "cases": {
        "new": null,
        "active": 30147,
        "critical": 342,
        "recovered": 6136591,
        "1M_pop": "121033",
        "total": 6308558
      },
      "deaths": {
        "new": null,
        "1M_pop": "2721",
        "total": 141820
      },
      "tests": {
        "1M_pop": "703232",
        "total": 36654229
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Portugal",
      "population": 10128810,
      "cases": {
        "new": null,
        "active": 49695,
        "critical": 61,
        "recovered": 5434604,
        "1M_pop": "543936",
        "total": 5509424
      },
      "deaths": {
        "new": null,
        "1M_pop": "2481",
        "total": 25125
      },
      "tests": {
        "1M_pop": "4448690",
        "total": 45059939
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Austria",
      "population": 9123827,
      "cases": {
        "new": "+6297",
        "active": 123466,
        "critical": 47,
        "recovered": 5202545,
        "1M_pop": "586041",
        "total": 5346939
      },
      "deaths": {
        "new": null,
        "1M_pop": "2294",
        "total": 20928
      },
      "tests": {
        "1M_pop": "21807971",
        "total": 198972158
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Ukraine",
      "population": 43133868,
      "cases": {
        "new": null,
        "active": 6307,
        "critical": 177,
        "recovered": 5061704,
        "1M_pop": "120027",
        "total": 5177217
      },
      "deaths": {
        "new": null,
        "1M_pop": "2532",
        "total": 109206
      },
      "tests": {
        "1M_pop": "452574",
        "total": 19521252
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Romania",
      "population": 18944700,
      "cases": {
        "new": "+305",
        "active": 10219,
        "critical": 97,
        "recovered": 3202822,
        "1M_pop": "173144",
        "total": 3280165
      },
      "deaths": {
        "new": "+4",
        "1M_pop": "3543",
        "total": 67124
      },
      "tests": {
        "1M_pop": "1335845",
        "total": 25307177
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Greece",
      "population": 10306801,
      "cases": {
        "new": null,
        "active": 36735,
        "critical": 115,
        "recovered": 4956446,
        "1M_pop": "487687",
        "total": 5026494
      },
      "deaths": {
        "new": null,
        "1M_pop": "3232",
        "total": 33313
      },
      "tests": {
        "1M_pop": "9269268",
        "total": 95536498
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Malaysia",
      "population": 33313897,
      "cases": {
        "new": null,
        "active": 23892,
        "critical": 36,
        "recovered": 4806883,
        "1M_pop": "146101",
        "total": 4867192
      },
      "deaths": {
        "new": null,
        "1M_pop": "1093",
        "total": 36417
      },
      "tests": {
        "1M_pop": "1951135",
        "total": 64999917
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "DPRK",
      "population": 26036957,
      "cases": {
        "new": null,
        "active": 0,
        "critical": null,
        "recovered": 4772739,
        "1M_pop": "183309",
        "total": 4772813
      },
      "deaths": {
        "new": null,
        "1M_pop": "3",
        "total": 74
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Bangladesh",
      "population": 168439485,
      "cases": {
        "new": "+389",
        "active": 28578,
        "critical": 1331,
        "recovered": 1974852,
        "1M_pop": "12069",
        "total": 2032832
      },
      "deaths": {
        "new": "+1",
        "1M_pop": "175",
        "total": 29402
      },
      "tests": {
        "1M_pop": "88755",
        "total": 14949905
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Thailand",
      "population": 70200133,
      "cases": {
        "new": null,
        "active": 4890,
        "critical": 1496,
        "recovered": 4649509,
        "1M_pop": "66770",
        "total": 4687281
      },
      "deaths": {
        "new": null,
        "1M_pop": "468",
        "total": 32882
      },
      "tests": {
        "1M_pop": "246022",
        "total": 17270775
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Belgium",
      "population": 11704873,
      "cases": {
        "new": null,
        "active": 73569,
        "critical": 68,
        "recovered": 4480219,
        "1M_pop": "391851",
        "total": 4586564
      },
      "deaths": {
        "new": null,
        "1M_pop": "2800",
        "total": 32776
      },
      "tests": {
        "1M_pop": "3057458",
        "total": 35787160
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "North-America",
      "country": "Canada",
      "population": 38498455,
      "cases": {
        "new": null,
        "active": 72182,
        "critical": 99,
        "recovered": 4175402,
        "1M_pop": "111518",
        "total": 4293273
      },
      "deaths": {
        "new": null,
        "1M_pop": "1187",
        "total": 45689
      },
      "tests": {
        "1M_pop": "1699096",
        "total": 65412557
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "South-America",
      "country": "Peru",
      "population": 34021774,
      "cases": {
        "new": null,
        "active": 5095,
        "critical": 118,
        "recovered": 3928589,
        "1M_pop": "121997",
        "total": 4150544
      },
      "deaths": {
        "new": null,
        "1M_pop": "6374",
        "total": 216860
      },
      "tests": {
        "1M_pop": "1042333",
        "total": 35462029
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Italy",
      "population": 60258762,
      "cases": {
        "new": "+14030",
        "active": 544088,
        "critical": 254,
        "recovered": 22391844,
        "1M_pop": "383579",
        "total": 23114013
      },
      "deaths": {
        "new": "+93",
        "1M_pop": "2955",
        "total": 178081
      },
      "tests": {
        "1M_pop": "4151374",
        "total": 250156683
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Switzerland",
      "population": 8799264,
      "cases": {
        "new": null,
        "active": 82439,
        "critical": 54,
        "recovered": 4047805,
        "1M_pop": "470999",
        "total": 4144447
      },
      "deaths": {
        "new": null,
        "1M_pop": "1614",
        "total": 14203
      },
      "tests": {
        "1M_pop": "2554417",
        "total": 22476990
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "South-America",
      "country": "Chile",
      "population": 19491226,
      "cases": {
        "new": "+3423",
        "active": 19744,
        "critical": 85,
        "recovered": 4600875,
        "1M_pop": "240214",
        "total": 4682067
      },
      "deaths": {
        "new": "+15",
        "1M_pop": "3153",
        "total": 61448
      },
      "tests": {
        "1M_pop": "2343355",
        "total": 45674866
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Czechia",
      "population": 10754369,
      "cases": {
        "new": "+219",
        "active": 15454,
        "critical": 54,
        "recovered": 4084227,
        "1M_pop": "385059",
        "total": 4141069
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "3848",
        "total": 41388
      },
      "tests": {
        "1M_pop": "5242543",
        "total": 56380239
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Africa",
      "country": "Morocco",
      "population": 37910564,
      "cases": {
        "new": "+12",
        "active": 136,
        "critical": 293,
        "recovered": 1248817,
        "1M_pop": "33374",
        "total": 1265232
      },
      "deaths": {
        "new": null,
        "1M_pop": "429",
        "total": 16279
      },
      "tests": {
        "1M_pop": "333110",
        "total": 12628380
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Sweden",
      "population": 10243171,
      "cases": {
        "new": null,
        "active": 24685,
        "critical": 17,
        "recovered": 2559774,
        "1M_pop": "254303",
        "total": 2604866
      },
      "deaths": {
        "new": null,
        "1M_pop": "1992",
        "total": 20407
      },
      "tests": {
        "1M_pop": "1855916",
        "total": 19010468
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Iraq",
      "population": 42286149,
      "cases": {
        "new": null,
        "active": 464,
        "critical": 21,
        "recovered": 2435048,
        "1M_pop": "58196",
        "total": 2460868
      },
      "deaths": {
        "new": null,
        "1M_pop": "600",
        "total": 25356
      },
      "tests": {
        "1M_pop": "457619",
        "total": 19350944
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Hungary",
      "population": 9604329,
      "cases": {
        "new": null,
        "active": 36163,
        "critical": 32,
        "recovered": 2036700,
        "1M_pop": "220790",
        "total": 2120543
      },
      "deaths": {
        "new": null,
        "1M_pop": "4964",
        "total": 47680
      },
      "tests": {
        "1M_pop": "1186398",
        "total": 11394556
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Africa",
      "country": "South-Africa",
      "population": 61017944,
      "cases": {
        "new": "+374",
        "active": 8980,
        "critical": 192,
        "recovered": 3912506,
        "1M_pop": "65943",
        "total": 4023732
      },
      "deaths": {
        "new": null,
        "1M_pop": "1676",
        "total": 102246
      },
      "tests": {
        "1M_pop": "428963",
        "total": 26174429
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Oceania",
      "country": "New-Zealand",
      "population": 5002100,
      "cases": {
        "new": "+2041",
        "active": 13303,
        "critical": null,
        "recovered": 1798540,
        "1M_pop": "362826",
        "total": 1814890
      },
      "deaths": {
        "new": "+5",
        "1M_pop": "609",
        "total": 3047
      },
      "tests": {
        "1M_pop": "1508179",
        "total": 7544063
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Georgia",
      "population": 3971678,
      "cases": {
        "new": null,
        "active": 126498,
        "critical": null,
        "recovered": 1637293,
        "1M_pop": "448347",
        "total": 1780691
      },
      "deaths": {
        "new": null,
        "1M_pop": "4255",
        "total": 16900
      },
      "tests": {
        "1M_pop": "4260184",
        "total": 16920079
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Jordan",
      "population": 10434643,
      "cases": {
        "new": null,
        "active": 1868,
        "critical": 59,
        "recovered": 1731007,
        "1M_pop": "167423",
        "total": 1746997
      },
      "deaths": {
        "new": null,
        "1M_pop": "1353",
        "total": 14122
      },
      "tests": {
        "1M_pop": "1648536",
        "total": 17201885
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "France",
      "population": 65603494,
      "cases": {
        "new": "+9421",
        "active": 1029742,
        "critical": 869,
        "recovered": 35082306,
        "1M_pop": "552837",
        "total": 36268028
      },
      "deaths": {
        "new": "+112",
        "1M_pop": "2378",
        "total": 155980
      },
      "tests": {
        "1M_pop": "4138350",
        "total": 271490188
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Pakistan",
      "population": 230698226,
      "cases": {
        "new": "+38",
        "active": 4093,
        "critical": 24,
        "recovered": 1538689,
        "1M_pop": "6820",
        "total": 1573403
      },
      "deaths": {
        "new": "+1",
        "1M_pop": "133",
        "total": 30621
      },
      "tests": {
        "1M_pop": "132515",
        "total": 30570862
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Israel",
      "population": 9326000,
      "cases": {
        "new": "+680",
        "active": 5822,
        "critical": 90,
        "recovered": 4655872,
        "1M_pop": "501116",
        "total": 4673411
      },
      "deaths": {
        "new": "+5",
        "1M_pop": "1256",
        "total": 11717
      },
      "tests": {
        "1M_pop": "4436346",
        "total": 41373364
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Kazakhstan",
      "population": 19290079,
      "cases": {
        "new": "+12",
        "active": 1153,
        "critical": 24,
        "recovered": 1379442,
        "1M_pop": "72280",
        "total": 1394287
      },
      "deaths": {
        "new": null,
        "1M_pop": "710",
        "total": 13692
      },
      "tests": {
        "1M_pop": "600050",
        "total": 11575012
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Finland",
      "population": 5560384,
      "cases": {
        "new": null,
        "active": 30319,
        "critical": 21,
        "recovered": 1286894,
        "1M_pop": "238015",
        "total": 1323455
      },
      "deaths": {
        "new": null,
        "1M_pop": "1123",
        "total": 6242
      },
      "tests": {
        "1M_pop": "2082921",
        "total": 11581841
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Lithuania",
      "population": 2635624,
      "cases": {
        "new": "+46",
        "active": 14946,
        "critical": 8,
        "recovered": 1237334,
        "1M_pop": "478689",
        "total": 1261643
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "3552",
        "total": 9363
      },
      "tests": {
        "1M_pop": "3871529",
        "total": 10203894
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Europe",
      "country": "Serbia",
      "population": 8657003,
      "cases": {
        "new": "+1433",
        "active": 30447,
        "critical": 18,
        "recovered": 2342396,
        "1M_pop": "276076",
        "total": 2389987
      },
      "deaths": {
        "new": "+10",
        "1M_pop": "1980",
        "total": 17144
      },
      "tests": {
        "1M_pop": "1297323",
        "total": 11230929
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Lebanon",
      "population": 6755650,
      "cases": {
        "new": null,
        "active": 118724,
        "critical": 74,
        "recovered": 1087587,
        "1M_pop": "180145",
        "total": 1216999
      },
      "deaths": {
        "new": null,
        "1M_pop": "1582",
        "total": 10688
      },
      "tests": {
        "1M_pop": "709862",
        "total": 4795578
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Africa",
      "country": "Tunisia",
      "population": 12101275,
      "cases": {
        "new": null,
        "active": null,
        "critical": 101,
        "recovered": null,
        "1M_pop": "94695",
        "total": 1145930
      },
      "deaths": {
        "new": null,
        "1M_pop": "2417",
        "total": 29254
      },
      "tests": {
        "1M_pop": "409235",
        "total": 4952266
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "North-America",
      "country": "Costa-Rica",
      "population": 5200433,
      "cases": {
        "new": null,
        "active": 257917,
        "critical": 52,
        "recovered": 860711,
        "1M_pop": "216828",
        "total": 1127602
      },
      "deaths": {
        "new": null,
        "1M_pop": "1726",
        "total": 8974
      },
      "tests": {
        "1M_pop": "896033",
        "total": 4659757
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "India",
      "population": 1411014280,
      "cases": {
        "new": "+1116",
        "active": 27950,
        "critical": 698,
        "recovered": 44075149,
        "1M_pop": "31631",
        "total": 44632004
      },
      "deaths": {
        "new": null,
        "1M_pop": "375",
        "total": 528905
      },
      "tests": {
        "1M_pop": "636335",
        "total": 897877536
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": "Asia",
      "country": "Singapore",
      "population": 5955494,
      "cases": {
        "new": "+5196",
        "active": 92225,
        "critical": 15,
        "recovered": 1923390,
        "1M_pop": "338723",
        "total": 2017261
      },
      "deaths": {
        "new": "+2",
        "1M_pop": "276",
        "total": 1646
      },
      "tests": {
        "1M_pop": "4122016",
        "total": 24548641
      },
      "day": "2022-10-18",
      "time": "2022-10-18T00:00:03+00:00"
    },
    {
      "continent": null,
      "country": "MS-Zaandam-",
      "population": null,
      "cases": {
        "new": "+7",
        "active": 7,
        "critical": null,
        "recovered": null,
        "1M_pop": null,
        "total": 9
      },
      "deaths": {
        "new": "+2",
        "1M_pop": null,
        "total": 2
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2020-04-09",
      "time": "2020-04-09T15:45:06+00:00"
    },
    {
      "continent": null,
      "country": "Diamond-Princess-",
      "population": null,
      "cases": {
        "new": null,
        "active": 82,
        "critical": 10,
        "recovered": 619,
        "1M_pop": null,
        "total": 712
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": 11
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2020-04-09",
      "time": "2020-04-09T15:45:06+00:00"
    },
    {
      "continent": null,
      "country": "US-Virgin-Islands",
      "population": null,
      "cases": {
        "new": "+11",
        "active": 17,
        "critical": null,
        "recovered": null,
        "1M_pop": "163",
        "total": 17
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
      "day": "2020-03-25",
      "time": "2020-03-25T06:00:07+00:00"
    },
    {
      "continent": null,
      "country": "Puerto-Rico",
      "population": null,
      "cases": {
        "new": "+8",
        "active": 36,
        "critical": null,
        "recovered": 1,
        "1M_pop": "14",
        "total": 39
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": 2
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2020-03-25",
      "time": "2020-03-25T06:00:07+00:00"
    },
    {
      "continent": null,
      "country": "Guam",
      "population": null,
      "cases": {
        "new": "+3",
        "active": 31,
        "critical": null,
        "recovered": null,
        "1M_pop": "190",
        "total": 32
      },
      "deaths": {
        "new": null,
        "1M_pop": null,
        "total": 1
      },
      "tests": {
        "1M_pop": null,
        "total": null
      },
      "day": "2020-03-25",
      "time": "2020-03-25T06:00:07+00:00"
    }
  ]
}
 */
