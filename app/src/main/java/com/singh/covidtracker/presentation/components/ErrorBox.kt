package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorBox(
    modifier : Modifier = Modifier,
    text: String,
) {
    RoundedCard(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.error
        )
    }
}

@Preview
@Composable
fun ErrorBoxPreview() {
    ErrorBox(text = "Unable to show Covid statistics.\nTry again later...")
}
