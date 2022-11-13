package com.singh.covidtracker.domain.repo

import com.singh.covidtracker.domain.model.CovidStatistic

interface CovidStatisticsRepo : StateFullRepo<Map<String, CovidStatistic>>