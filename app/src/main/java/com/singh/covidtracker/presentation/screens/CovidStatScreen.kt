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
import com.singh.covidtracker.presentation.viewModel.impl.CovidStatisticsViewModelImpl
import com.singh.covidtracker.ui.WindowState
import com.singh.covidtracker.ui.theme.*
import com.singh.covidtracker.utils.State
import java.util.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CovidStatScreen(
    search: () -> Unit
) {
    val covidStatisticsViewModel: CovidStatisticsViewModel = hiltViewModel<CovidStatisticsViewModelImpl>()
    val updatedSearch by rememberUpdatedState(newValue = search)
    val currentSelectedCovidStats =
        covidStatisticsViewModel.selectedCountryCovidStatistic.collectAsStateWithLifecycle()

    BaseScreen(
        modifier = Modifier
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            covidStatisticsViewModel.showWorldStatistics()
                        },
                    painter = painterResource(id = R.drawable.covid_ribbon),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Inside,
                )

                Image(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            updatedSearch()
                        },
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    contentScale = ContentScale.Inside,
                )
            }
        }
        when (currentSelectedCovidStats.value) {
            is State.Success -> {
                val covidStatistic =
                    (currentSelectedCovidStats.value as State.Success<Pair<Country, CovidStatistic?>>).result.second
                val country =
                    (currentSelectedCovidStats.value as State.Success<Pair<Country, CovidStatistic?>>).result.first
                val covidHistory = covidStatisticsViewModel.fetchCovidStatistics(country)
                    .collectAsStateWithLifecycle()

                AdaptiveScreenLayout(
                    state = WindowState.getWindowState(LocalConfiguration.current.orientation),
                    country = country,
                    covidStatistic = covidStatistic,
                    covidHistory = covidHistory.value
                )
            }
            is State.Error -> ErrorBox(
                Modifier.fillMaxWidth(),
                text = "Unable to show Covid statistics.\nTry again later..."
            )
            else -> ProgressBox(Modifier.fillMaxSize())
        }
    }
}

@Composable
fun AdaptiveScreenLayout(
    state: WindowState,
    country: Country,
    covidStatistic: CovidStatistic?,
    covidHistory: State<CovidHistoryGraphData>
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (state == WindowState.LANDSCAPE) {
            CovidStatHeader(
                country = country,
                modifier = Modifier.fillMaxWidth(0.25f)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            if (state == WindowState.PORTRAIT) {
                CovidStatHeader(
                    country = country,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            covidStatistic?.let {
                CovidNewCasesCard(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    covidCases = it.cases
                )
            }
            covidStatistic?.let {
                CovidProgressStatCard(
                    modifier = Modifier.padding(8.dp),
                    covidStatistic = it
                )
            }
            // covid cases
            CovidHistoryCard(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                label = stringResource(id = R.string.cases),
                graphStartLabel = when (covidHistory) {
                    is State.Success -> {
                        covidHistory.result.startLabel
                    }
                    else -> ""
                },
                graphEndLabel = when (covidHistory) {
                    is State.Success -> {
                        covidHistory.result.endLabel
                    }
                    else -> ""
                },
                graphAccent = CovidBrightRed,
                graphData = when (covidHistory) {
                    is State.Success -> {
                        covidHistory.result.graphData
                    }
                    is State.Error -> null
                    else -> Pair(emptyList(), emptyList())
                }
            )

            // covid deaths
            CovidHistoryCard(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                label = stringResource(id = R.string.deaths),
                graphStartLabel = when (covidHistory) {
                    is State.Success -> {
                        covidHistory.result.startLabel
                    }
                    else -> ""
                },
                graphEndLabel = when (covidHistory) {
                    is State.Success -> {
                        covidHistory.result.endLabel
                    }
                    else -> ""
                },
                graphAccent = Color.White,
                graphData = when (covidHistory) {
                    is State.Success -> {
                        covidHistory.result.graphData
                    }
                    is State.Error -> null
                    else -> Pair(emptyList(), emptyList())
                }
            )
        }
    }
}