package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.ui.linearGradient
import com.singh.covidtracker.ui.theme.Green200
import com.singh.covidtracker.ui.theme.LightGrey200
import com.singh.covidtracker.ui.theme.LightGrey500
import com.singh.covidtracker.ui.theme.Purple200

@Composable
fun Banner(
    modifier: Modifier,
    elevation: Dp = 2.dp,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        shape = RoundedCornerShape(0.dp),
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        0.0f to Green200,
                        0.33f to LightGrey200,
                        0.70f to LightGrey200,
                        1.0f to Purple200,
                        angleInDegrees = 0.0f
                    )
                )
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun PreviewBanner() {
    Box(modifier = Modifier.fillMaxSize()) {
        Banner(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column() {
                Text("First")
                Text("Second")
                Text("Third")
            }
        }
    }
}