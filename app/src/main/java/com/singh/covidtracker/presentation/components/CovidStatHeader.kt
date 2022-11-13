package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.domain.model.Country

@Composable
fun CovidStatHeader(
    modifier: Modifier = Modifier,
    country: Country
) {
    Column(
        modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CountryFlag(
            modifier = Modifier,
            country = country,
            size = 96.dp
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = country.name,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun CovidStatHeaderPreview() {
    CovidStatHeader(
        country = Country(
            name = "World",
            flag = ""
        )
    )
}