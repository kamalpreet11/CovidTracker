package com.singh.covidtracker.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.singh.covidtracker.R
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidHistoryGraphData
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.presentation.components.*
import com.singh.covidtracker.presentation.viewModel.CovidStatisticsViewModel
import com.singh.covidtracker.presentation.viewModel.WorldCovidStatisticsViewModel
import com.singh.covidtracker.presentation.viewModel.impl.CovidStatisticsViewModelImpl
import com.singh.covidtracker.presentation.viewModel.impl.WorldStatisticsViewModelImpl
import com.singh.covidtracker.ui.WindowState
import com.singh.covidtracker.ui.theme.*
import com.singh.covidtracker.utils.State
import java.util.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun WorldCovidStatScreen() {
    val worldStatisticsViewModel: WorldCovidStatisticsViewModel =
        hiltViewModel<WorldStatisticsViewModelImpl>()
    val worldStatistics = worldStatisticsViewModel.worldCovidStatistic.collectAsStateWithLifecycle()
    BaseScreen(
        modifier = Modifier
    ) {
        when (worldStatistics.value) {
            is State.Success -> {
                val covidStatistic =
                    (worldStatistics.value as State.Success<CovidStatistic>).result

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    CovidNewCasesCard(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        covidCases = covidStatistic.cases
                    )
                    CovidProgressStatCard(
                        modifier = Modifier.padding(8.dp),
                        covidStatistic = covidStatistic
                    )
                }
            }
            is State.Error -> ErrorBox(
                Modifier.fillMaxWidth(),
                text = "Unable to show Covid statistics.\nTry again later..."
            )
            else -> ProgressBox(Modifier.fillMaxSize())
        }
    }
}