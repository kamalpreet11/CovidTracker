package com.singh.covidtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.singh.covidtracker.presentation.Navigation
import com.singh.covidtracker.ui.theme.CovidTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CovidTrackerTheme {
                // A surface container using the 'background' color from the theme
                Navigation()
            }
        }
    }
}