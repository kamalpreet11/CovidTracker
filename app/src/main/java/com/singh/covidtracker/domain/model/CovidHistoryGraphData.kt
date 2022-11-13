package com.singh.covidtracker.domain.model

import com.jaikeerthick.composable_graphs.data.GraphData

data class CovidHistoryGraphData(
    val startLabel: String,
    val endLabel: String,
    val graphData: Pair<List<GraphData>, List<Number>>?,
)
