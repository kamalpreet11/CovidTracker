package com.singh.covidtracker.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.singh.covidtracker.R
import com.singh.covidtracker.presentation.Routes
import com.singh.covidtracker.presentation.model.BottomNavigationItem
import com.singh.covidtracker.presentation.navigation.LandingNavigationGraph
import com.singh.covidtracker.ui.theme.Green500
import com.singh.covidtracker.ui.theme.Purple200
import com.singh.covidtracker.ui.theme.Purple500

@Composable
fun LandingScreen() {
    val landingNavHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier,
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
                    landingNavHostController.navigate(it.route) {
                        popUpTo(landingNavHostController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        },
    ) { innerContentPadding ->
        Box(modifier = Modifier.padding(innerContentPadding)) {
            LandingNavigationGraph(navHostController = landingNavHostController)
        }
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
        elevation = 5.dp,
        backgroundColor = Purple500,
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
                            style = MaterialTheme.typography.h5
                        )
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.primaryVariant
            )
        }
    }
}
