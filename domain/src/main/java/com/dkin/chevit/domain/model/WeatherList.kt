package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class WeatherList(
    val weatherList: List<Weather>,
    val webUrl: String
) : DomainModel
