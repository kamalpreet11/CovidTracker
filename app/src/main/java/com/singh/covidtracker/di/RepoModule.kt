package com.singh.covidtracker.di

import com.singh.covidtracker.data.repo.CountryRepoImpl
import com.singh.covidtracker.data.repo.CovidHistoryRepoImpl
import com.singh.covidtracker.data.repo.CovidStatisticsRepoImpl
import com.singh.covidtracker.data.repo.SelectedCountryRepoImpl
import com.singh.covidtracker.domain.repo.CountryRepo
import com.singh.covidtracker.domain.repo.CovidHistoryRepo
import com.singh.covidtracker.domain.repo.CovidStatisticsRepo
import com.singh.covidtracker.domain.repo.SelectedCountryRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepoModule {

    @Singleton
    @Binds
    fun bindsCountryRepo(countryRepoImpl: CountryRepoImpl) : CountryRepo

    @Singleton
    @Binds
    fun bindsCovidStatisticRepo(covidStatisticsRepoImpl: CovidStatisticsRepoImpl) : CovidStatisticsRepo

    @Singleton
    @Binds
    fun bindsCovidHistoryRepo(covidHistoryRepoImpl: CovidHistoryRepoImpl) : CovidHistoryRepo

    @Singleton
    @Binds
    fun bindsSelectedCountryRepo(selectedCountryRepoImpl: SelectedCountryRepoImpl) : SelectedCountryRepo

}