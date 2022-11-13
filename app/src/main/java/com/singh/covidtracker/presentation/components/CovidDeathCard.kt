package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.data.utils.formatToCount
import com.singh.covidtracker.domain.model.CovidDeaths
import com.singh.covidtracker.ui.theme.Charcoal

@Composable
fun CovidDeathCard(
    modifier: Modifier = Modifier,
    deaths: CovidDeaths?
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Deaths",
                style = MaterialTheme.typography.h4,
                color = Charcoal
            )
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Text(
                text = deaths?.new ?: "-",
                style = MaterialTheme.typography.body1,
                color = Color.Red
            )
            Text(
                text = deaths?.total?.formatToCount() ?: "-",
                style = MaterialTheme.typography.body1,
                color = Charcoal
            )
        }

    }
}

@Preview
@Composable
fun CovidDeathCardPreview() {
    CovidDeathCard(deaths = CovidDeaths(
        new = "100",
        total = 1000
    ))
}
