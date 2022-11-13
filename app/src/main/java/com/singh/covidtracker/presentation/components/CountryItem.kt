package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.ui.theme.Charcoal
import com.singh.covidtracker.ui.theme.Typography

@Composable
fun CountryItem(
    modifier: Modifier = Modifier,
    country: Country,
) {
    Card(
        elevation = 2.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        backgroundColor = Color.White,
    ) {
        Row(
            modifier = modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CountryFlag(country = country, size = 64.dp)
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Text(
                text = country.name,
                style = Typography.h4,
                color = Charcoal
            )
        }
    }
}

@Preview
@Composable
fun CountryItemPreview() {
    CountryItem(
        country = Country(
            "USA",
            ""
        )
    )
}