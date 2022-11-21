package com.singh.covidtracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.singh.covidtracker.presentation.Routes
import com.singh.covidtracker.presentation.screens.CovidStatScreen
import com.singh.covidtracker.presentation.screens.SelectCountryScreen
import com.singh.covidtracker.presentation.screens.WorldCovidStatScreen

@Composable
fun LandingNavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.WorldStatistics.route
    ) {
        composable(route = Routes.WorldStatistics.route) {
            WorldCovidStatScreen()
        }
        composable(route = Routes.CovidStatistics.route) {
            CovidStatScreen {
                navHostController.navigate(Routes.SelectCountry.route)
            }
        }
        composable(route = Routes.SelectCountry.route) {
            SelectCountryScreen {
                navHostController.popBackStack()
            }
        }
    }
}