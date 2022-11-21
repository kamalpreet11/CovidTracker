package com.singh.covidtracker.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.singh.covidtracker.ui.linearGradient
import com.singh.covidtracker.ui.theme.Green200
import com.singh.covidtracker.ui.theme.LightGrey200
import com.singh.covidtracker.ui.theme.Purple200

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun PreviewBaseScreen() {
    BaseScreen {
        Text("this is base screen")
    }
}