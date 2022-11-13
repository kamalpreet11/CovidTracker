package com.singh.covidtracker.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.ui.theme.CovidBrightYellow
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.PalettePlugin
import com.singh.covidtracker.R

@Composable
fun CountryFlag(
    modifier: Modifier = Modifier,
    country: Country,
    size: Dp = 96.dp,
) {
    var borderColor by remember {
        mutableStateOf(CovidBrightYellow)
    }
    var backgroundColor by remember {
        mutableStateOf(Color.LightGray)
    }
    Box(
        modifier = modifier
            .padding(2.dp)
            .clip(
                RoundedCornerShape(
                    size
                )
            )
            .border(
                BorderStroke(2.dp, borderColor), shape = RoundedCornerShape(
                    size
                )
            )
    ) {
        GlideImage(
            modifier = Modifier
                .size(
                    size
                )
                .padding(4.dp)
                .clip(
                    RoundedCornerShape(
                        size
                    )
                ),
            previewPlaceholder = R.drawable.generic_earth,
            imageModel = { country.flag },
            imageOptions = ImageOptions(
                contentDescription = country.name,
                contentScale = ContentScale.Fit,
            ),
            failure = {
                Image(
                    painter = painterResource(id = R.drawable.covid_ribbon),
                    contentDescription = stringResource(id = R.string.covid_statistics)
                )
                borderColor = CovidBrightYellow
            },
            component = rememberImageComponent {
                +PalettePlugin { palette ->
                    palette.dominantSwatch?.rgb?.let { rgb ->
                        borderColor = Color(rgb)
                    }
                    palette.mutedSwatch?.rgb?.let { rgb ->
                        backgroundColor = Color(rgb)
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun CountryFlagPreview() {
    CountryFlag(
        country = Country(
            "USA",
            flag = "https://countryflagsapi.com/png/usa"
        )
    )
}