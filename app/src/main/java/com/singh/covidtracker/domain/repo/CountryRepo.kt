package com.singh.covidtracker.domain.repo

import com.singh.covidtracker.domain.model.Country

interface CountryRepo : StateFullRepo<List<Country>>