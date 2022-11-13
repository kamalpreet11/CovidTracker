package com.singh.covidtracker.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.singh.covidtracker.ui.linearGradient
import com.singh.covidtracker.ui.theme.Charcoal
import com.singh.covidtracker.ui.theme.CovidBrightYellow
import com.singh.covidtracker.ui.theme.CovidMutedRed

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
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
//                .background(
//                    brush = Brush.linearGradient(
//                        0.0f to CovidBrightYellow,
//                        0.2f to CovidMutedRed,
//                        0.35f to Charcoal,
//                        angleInDegrees = 115.0f
//                    )
//                )
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}