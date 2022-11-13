package com.singh.covidtracker.domain.repo

import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.domain.model.CovidHistoryGraphData
import com.singh.covidtracker.utils.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import java.util.*

interface CovidHistoryRepo {

    fun getHistory(
        country: Country,
        date: Date = Date(),
        scope: CoroutineScope
    ) : StateFlow<State<CovidHistoryGraphData>>
}