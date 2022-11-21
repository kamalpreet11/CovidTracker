package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProgressBox(
    modifier: Modifier = Modifier,
    progressColor: Color = MaterialTheme.colors.secondary
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = progressColor)
    }
}

@Preview
@Composable
fun ProgressBoxPreview() {
    ProgressBox(Modifier.fillMaxSize())
}