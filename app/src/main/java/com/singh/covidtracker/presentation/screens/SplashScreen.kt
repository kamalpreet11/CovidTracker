package com.singh.covidtracker.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.singh.covidtracker.R
import com.singh.covidtracker.presentation.components.Banner
import com.singh.covidtracker.presentation.components.RoundedCard
import com.singh.covidtracker.presentation.viewModel.CovidStatisticsViewModel
import com.singh.covidtracker.presentation.viewModel.SnapShotViewModel
import com.singh.covidtracker.presentation.viewModel.impl.CovidStatisticsViewModelImpl
import com.singh.covidtracker.presentation.viewModel.impl.SnapShotViewModelImpl
import com.singh.covidtracker.utils.State

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SplashScreen(
    finishSplash: () -> Unit
) {
    val snapShotViewModel: SnapShotViewModel = hiltViewModel<SnapShotViewModelImpl>()
    val updatedFinishSplash by rememberUpdatedState(newValue = finishSplash)

    val covidData =
        snapShotViewModel.appDataReady.collectAsStateWithLifecycle()
    var dataLoading by remember {
        mutableStateOf(true)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Banner(
                modifier = Modifier
                    .fillMaxSize()
            ) {}

            Image(
                painter = painterResource(id = R.drawable.covid_ribbon),
                contentDescription = stringResource(
                    id = R.string.app_name
                )
            )

            if (dataLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(92.dp)
                )
            } else {
                Text(
                    modifier = Modifier.padding(top = 108.dp),
                    text = stringResource(id = R.string.error_no_statistics_found),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.error
                )
            }

            when (covidData.value) {
                is State.Success -> {
                    LaunchedEffect(key1 = true) {
                        updatedFinishSplash()
                    }
                }
                is State.Error -> {
                    dataLoading = false
                }
                else -> {}
            }
        }
    }
}