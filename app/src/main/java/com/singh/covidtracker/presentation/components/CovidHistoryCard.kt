package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jaikeerthick.composable_graphs.color.LinearGraphColors
import com.jaikeerthick.composable_graphs.composables.LineGraph
import com.jaikeerthick.composable_graphs.data.GraphData
import com.jaikeerthick.composable_graphs.style.LineGraphStyle
import com.jaikeerthick.composable_graphs.style.LinearGraphVisibility

@Composable
fun CovidHistoryCard(
    modifier: Modifier = Modifier,
    label: String,
    labelColor: Color = MaterialTheme.colors.onSurface,
    graphStartLabel: String,
    graphEndLabel: String,
    graphAccent: Color,
    graphData: Pair<List<GraphData>, List<Number>>?,
) {
    RoundedCard(modifier, verticalArrangement = Arrangement.Center) {
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.h4,
            text = label,
            color = labelColor
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            if (graphData == null) {
                Text(
                    text = "History data not available",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            graphData?.let { _graphData ->
                if (_graphData.first.isNotEmpty() && _graphData.second.isNotEmpty()) {
                    LineGraph(
                        xAxisData = _graphData.first,
                        yAxisData = _graphData.second,
                        style = LineGraphStyle(
                            colors = LinearGraphColors(
                                lineColor = graphAccent,//Color.Transparent,
                                pointColor = Color.Transparent,
                                fillGradient = Brush.verticalGradient(
                                    listOf(
                                        graphAccent,
                                        Color.Transparent
                                    )
                                ),
                                clickHighlightColor = MaterialTheme.colors.primary
                            ),
                            paddingValues = PaddingValues(0.dp),
                            visibility = LinearGraphVisibility(
                                isCrossHairVisible = true,
                                isGridVisible = false,
                            )
                        )
                    )
                } else {
                    ProgressBox()
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.caption,
                text = graphStartLabel, //dateFormatter.getTimeString(cases.last().time ?: Date()),
                color = graphAccent,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.caption,
                text = graphEndLabel,//dateFormatter.getTimeString(cases.first().time ?: Date()),
                color = graphAccent,
                textAlign = TextAlign.Center
            )
        }
    }
}