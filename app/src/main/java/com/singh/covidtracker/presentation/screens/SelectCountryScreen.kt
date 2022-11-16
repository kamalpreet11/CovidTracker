package com.singh.covidtracker.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.singh.covidtracker.R
import com.singh.covidtracker.domain.model.Country
import com.singh.covidtracker.presentation.components.CountryItem
import com.singh.covidtracker.presentation.viewModel.SelectCountryViewModel
import com.singh.covidtracker.presentation.viewModel.impl.SelectCountryViewModelImpl
import com.singh.covidtracker.utils.State

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SelectCountryScreen(
    onExit: () -> Unit
) {
    val selectCountryViewModel : SelectCountryViewModel = hiltViewModel<SelectCountryViewModelImpl>()
    val updatedOnExit by rememberUpdatedState(newValue = onExit)
    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }
    val countriesResponse = selectCountryViewModel.countries.collectAsStateWithLifecycle()
    val countries by remember {
        derivedStateOf {
            when (countriesResponse.value) {
                is State.Success -> {
                    (countriesResponse.value as State.Success<List<Country>>).result.filter {
                        it.name.uppercase().contains(searchQuery.uppercase())
                    }
                }
                else -> emptyList()
            }
        }
    }

    BaseScreen {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(56.dp)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            updatedOnExit()
                        },
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(LocalContentColor.current.copy(alpha = LocalContentAlpha.current))
                )

                Text(
                    text = stringResource(id = R.string.select_country),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    style = MaterialTheme.typography.h2
                )
            }
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            value = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            placeholder = {
                Text(text = "Search Country")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(autoCorrect = false),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    Image(
                        painter = painterResource(id = R.drawable.clear),
                        contentDescription = "Clear",
                        modifier = Modifier.clickable {
                            searchQuery = ""
                        }
                    )
                }
            }
        )

        LazyColumn {
            items(
                countries
            ) { country ->
                CountryItem(country = country, modifier = Modifier.clickable {
                    selectCountryViewModel.selectCountry(country)
                    updatedOnExit()
                })
            }
        }
    }
}