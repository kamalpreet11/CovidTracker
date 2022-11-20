package com.singh.covidtracker.presentation.model

import androidx.compose.ui.graphics.painter.Painter
import com.singh.covidtracker.presentation.Routes

data class BottomNavigationItem(
    val icon: Painter,
    val label: String,
    val route: Routes
)
