package com.singh.covidtracker.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/*

primary - The primary color is the color displayed most frequently across your app’s screens and components.
primaryVariant - The primary variant color is used to distinguish two elements of the app using the primary color, such as the top app bar and the system bar.
secondary -
The secondary color provides more ways to accent and distinguish your product. Secondary colors are best for:
Floating action buttons
Selection controls, like checkboxes and radio buttons
Highlighting selected text
Links and headlines
secondaryVariant - The secondary variant color is used to distinguish two elements of the app using the secondary color.
background - The background color appears behind scrollable content.
surface - The surface color is used on surfaces of components, such as cards, sheets and menus.
error - The error color is used to indicate error within components, such as text fields.
onPrimary - Color used for text and icons displayed on top of the primary color.
onSecondary - Color used for text and icons displayed on top of the secondary color.
onBackground - Color used for text and icons displayed on top of the background color.
onSurface - Color used for text and icons displayed on top of the surface color.
onError - Color used for text and icons displayed on top of the error color.
isLight - Whether this Colors is considered as a 'light' or 'dark' set of colors. This affects default behavior for some components: for example, in a light theme a TopAppBar will use primary by default for its background color, when in a dark theme it will use surface.
 */
private val ColorPalette = Colors(
    primary = Green500,
    primaryVariant = Green200,
    onPrimary = Charcoal,

    secondary = Purple500,
    secondaryVariant = Purple200,
    onSecondary = Charcoal,

    background = Purple200,
    onBackground = Green200,

    surface = Green500,
    onSurface = Charcoal,

    error = CovidBrightRed,
    onError = CovidBrightYellow,

    isLight = false,
)

@Composable
fun CovidTrackerTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {

    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}

@Preview
@Composable
fun CovidTrackerThemePreview() {
    CovidTrackerTheme() {
        Surface(Modifier.fillMaxSize()) {}
    }
}