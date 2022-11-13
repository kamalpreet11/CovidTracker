package com.singh.covidtracker.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singh.covidtracker.presentation.screens.CovidStatScreen
import com.singh.covidtracker.presentation.screens.SelectCountryScreen
import com.singh.covidtracker.presentation.screens.SplashScreen
import com.singh.covidtracker.presentation.viewModel.CovidStatisticsViewModel
import com.singh.covidtracker.presentation.viewModel.impl.CovidStatisticsViewModelImpl

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val covidStatisticsViewModel: CovidStatisticsViewModel = hiltViewModel<CovidStatisticsViewModelImpl>()
    NavHost(navController = navController, startDestination = Routes.Splash.route) {
        composable(route = Routes.Splash.route) {
            SplashScreen(covidStatisticsViewModel) {
                navController.navigate(Routes.CovidStatistics.route) {
                    popUpTo(Routes.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = Routes.CovidStatistics.route) {
            CovidStatScreen(covidStatisticsViewModel) {
                navController.navigate(Routes.SelectCountry.route)
            }
        }
        composable(route = Routes.SelectCountry.route) {
            SelectCountryScreen(covidStatisticsViewModel) {
                navController.popBackStack(Routes.CovidStatistics.route, false)
            }
        }
    }
}