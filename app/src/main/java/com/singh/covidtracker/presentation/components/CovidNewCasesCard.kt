
package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.singh.covidtracker.R
import com.singh.covidtracker.domain.model.CovidCases

@Composable
fun CovidNewCasesCard(
    modifier: Modifier = Modifier,
    covidCases: CovidCases?,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.new_covid_cases),
            style = MaterialTheme.typography.h1,
        )
        Text(
            text = covidCases?.new ?: "-",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.error
        )
    }
}

@Preview
@Composable
fun CovidNewCasesCardPreview() {
    CovidNewCasesCard(
        modifier = Modifier.fillMaxWidth(),
        covidCases = CovidCases(
            new = "+919",
            active = 100,
            critical = 10,
            recovered = 90,
            total = 5000
        )
    )
}