package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.ui.theme.Typography

@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    title: String,
    label: String,
    labelHint: Color = MaterialTheme.colors.primary
) {
    Card(elevation = 2.dp) {
        Column(
            modifier = modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = Typography.h4
            )
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Text(
                text = label,
                style = Typography.caption,
                color = labelHint,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun StatCardPreview() {
    StatCard(title = "Title", label = "label")
}