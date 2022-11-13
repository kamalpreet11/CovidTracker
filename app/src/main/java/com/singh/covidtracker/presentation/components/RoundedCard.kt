package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    roundedCorners: Dp = 12.dp,
    verticalArrangement : Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment : Alignment.Horizontal = Alignment.Start,
    content: @Composable () -> Unit,
) {
    Column(
        modifier
            .clip(
                RoundedCornerShape(roundedCorners)
            )
            .background(
                color = MaterialTheme.colors.surface,
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(roundedCorners)
            )
            .padding(16.dp),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        content()
    }
}