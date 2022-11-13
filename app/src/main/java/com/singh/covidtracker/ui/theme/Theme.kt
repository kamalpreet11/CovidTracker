package com.singh.covidtracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

private val ColorPalette = Colors(
    primary = CovidBrightYellow,
    primaryVariant = CovidDullYellow,
    onPrimary = White,

    secondary = CovidMutedRed,
    secondaryVariant = CovidDullYellow,
    onSecondary = CovidMutedRed,

    background = Charcoal,
    onBackground = CovidMutedYellow,

    surface = White25,
    onSurface = Color.White,

    error = CovidBrightRed,
    onError = CovidBrightYellow,

    isLight = false,
)

@Composable
fun CovidTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Preview
@Composable
fun CovidTrackerThemePreview() {
    CovidTrackerTheme() {
        Surface(Modifier.fillMaxSize()) {}
    }
}