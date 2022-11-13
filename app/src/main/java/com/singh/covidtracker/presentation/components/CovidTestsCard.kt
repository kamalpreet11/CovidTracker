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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.data.utils.formatToCount
import com.singh.covidtracker.domain.model.CovidTests
import com.singh.covidtracker.ui.theme.Charcoal

@Composable
fun CovidTestsCard(
    modifier: Modifier = Modifier,
    tests: CovidTests?
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
                text = "Tests",
                style = MaterialTheme.typography.h4,
                color = Charcoal
            )
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Text(
                text = tests?.total?.formatToCount() ?: "-",
                style = MaterialTheme.typography.body1,
                color = Charcoal
            )
        }
    }
}

@Preview
@Composable
fun CovidTestsCardPreview() {
    CovidTestsCard(
        tests = CovidTests(
            total = 1000
        )
    )
}
