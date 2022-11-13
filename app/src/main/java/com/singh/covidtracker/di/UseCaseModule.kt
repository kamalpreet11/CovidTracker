package com.singh.covidtracker.di

import com.singh.covidtracker.domain.useCase.CountryCovidStatisticsUseCase
import com.singh.covidtracker.domain.useCase.WorldCovidStatisticsUseCase
import com.singh.covidtracker.domain.useCase.impl.CountryCovidStatisticsUseCaseImpl
import com.singh.covidtracker.domain.useCase.impl.WorldCovidStatisticsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    abstract fun bindCountryCovidStatisticsUseCaseImpl(
        countryCovidStatisticsUseCaseImpl: CountryCovidStatisticsUseCaseImpl
    ): CountryCovidStatisticsUseCase

    @Binds
    abstract fun bindWorldStatisticsUseCaseImpl(
        worldCovidStatisticsUseCaseImpl: WorldCovidStatisticsUseCaseImpl
    ) : WorldCovidStatisticsUseCase
}