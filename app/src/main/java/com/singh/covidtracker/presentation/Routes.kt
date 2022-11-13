package com.singh.covidtracker.presentation

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object CovidStatistics : Routes("covidStats")
    object SelectCountry : Routes("selectCountry")
}
