package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.data.utils.formatToCount
import com.singh.covidtracker.domain.model.CovidCases
import com.singh.covidtracker.domain.model.CovidDeaths
import com.singh.covidtracker.domain.model.CovidStatistic
import com.singh.covidtracker.domain.model.CovidTests
import com.singh.covidtracker.ui.theme.CovidBrightRed
import com.singh.covidtracker.ui.theme.CovidBrightYellow
import com.singh.covidtracker.ui.theme.CovidMutedRed
import java.util.*

@Composable
fun CovidProgressStatCard(
    modifier: Modifier = Modifier,
    covidStatistic: CovidStatistic,
) {
    val spacing = 18.dp

    RoundedCard(
        modifier = modifier
    ) {

        val total = covidStatistic.population ?: 1

        InfoProgressBar(
            total = total,
            progress = total,
            label = "Population",
            info = covidStatistic.population?.formatToCount() ?: ""
        )
        Spacer(modifier = Modifier.padding(top = spacing))

        InfoProgressBar(
            total = total,
            progress = covidStatistic.cases?.total ?: 1,
            label = "Cases",
            info = covidStatistic.cases?.total?.formatToCount() ?: "",
//            progressColor = CovidBrightRed
        )
        Spacer(modifier = Modifier.padding(top = spacing))

        InfoProgressBar(
            total = total,
            progress = covidStatistic.cases?.recovered ?: 1,
            label = "Recovered",
            info = covidStatistic.cases?.recovered?.formatToCount() ?: "",
//            progressColor = Color.Green
        )
        Spacer(modifier = Modifier.padding(top = spacing))

        InfoProgressBar(
            total = total,
            progress = covidStatistic.cases?.active ?: 1,
            label = "Active",
            info = covidStatistic.cases?.active?.formatToCount() ?: "",
//            progressColor = CovidBrightYellow
        )
    }
}

@Preview
@Composable
fun CovidProgressStatCardPreview() {
    CovidProgressStatCard(
        modifier = Modifier.fillMaxWidth(),
        covidStatistic = CovidStatistic(
            population = 10000,
            country = "Sample",
            continent = "Sample",
            time = Date(),
            cases = CovidCases(
                new = "+919",
                active = 100,
                critical = 10,
                recovered = 90,
                total = 5000
            ),
            deaths = CovidDeaths(
                new = "10",
                total = 200,
            ),
            tests = CovidTests(
                total = 2000
            )
        )
    )
}