package com.singh.covidtracker.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InfoProgressBar(
    modifier: Modifier = Modifier,
    label: String = "",
    info: String = "",
    total: Long,
    progress: Long = 0,
    progressColor: Color = Color.White
) {
    val targetProgress = progress.toFloat() / total
    val animatingProgress = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = targetProgress) {
        animatingProgress.animateTo(
            targetProgress,
            animationSpec = tween(durationMillis = 550, delayMillis = 250)
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = info,
                style = MaterialTheme.typography.subtitle1,
            )
        }
        Spacer(modifier = Modifier.padding(top = 4.dp))
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .clip(
                    shape = RoundedCornerShape(12.dp)
                ),
            progress = animatingProgress.value,
            color = progressColor
        )
    }
}

@Preview
@Composable
fun InfoProgressBarPreview() {
    InfoProgressBar(
        total = 100,
        label = "Progress",
        info = "Info",
        progress = 60,
        progressColor = MaterialTheme.colors.primary
    )
}