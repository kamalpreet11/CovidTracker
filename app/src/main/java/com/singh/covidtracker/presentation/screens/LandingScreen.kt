package com.singh.covidtracker.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.singh.covidtracker.presentation.Routes
import com.singh.covidtracker.presentation.model.BottomNavigationItem
import com.singh.covidtracker.presentation.navigation.LandingNavigationGraph
import com.singh.covidtracker.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LandingScreen() {
    val landingNavHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(
                navController = landingNavHostController,
                items = listOf(
                    BottomNavigationItem(
                        icon = painterResource(id = R.drawable.home),
                        label = stringResource(id = R.string.world_tab),
                        route = Routes.WorldStatistics
                    ),
                    BottomNavigationItem(
                        icon = painterResource(id = R.drawable.world),
                        label = stringResource(id = R.string.countries_tab),
                        route = Routes.CovidStatistics
                    )
                ),
                onItemClicked = {
                    landingNavHostController.navigate(it.route)
                }
            )
        },
    ) {
        LandingNavigationGraph(navHostController = landingNavHostController)
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomNavigationItem>,
    onItemClicked: (route: Routes) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.LightGray
    ) {
        items.forEach { item ->
            val selected = item.route.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClicked(item.route) },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(item.icon, contentDescription = item.label)
                        Text(
                            text = item.label,
                            style = if (selected) MaterialTheme.typography.h4 else MaterialTheme.typography.caption
                        )
                    }
                }
            )
        }
    }
}
