package com.singh.covidtracker.presentation.viewModel

import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.StateFlow

interface SnapShotViewModel {

    val appDataReady : StateFlow<State<Boolean>>
}