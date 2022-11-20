package com.singh.covidtracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singh.covidtracker.presentation.Routes
import com.singh.covidtracker.presentation.screens.LandingScreen
import com.singh.covidtracker.presentation.screens.SplashScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Splash.route) {
        composable(route = Routes.Splash.route) {
            SplashScreen {
                navController.navigate(Routes.MainLanding.route) {
                    popUpTo(Routes.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = Routes.MainLanding.route) {
            LandingScreen()
        }
    }
}