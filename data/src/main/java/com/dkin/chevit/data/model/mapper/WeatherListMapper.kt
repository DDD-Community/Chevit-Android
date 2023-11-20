package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.WeatherListResponse
import com.dkin.chevit.domain.model.WeatherList

internal object WeatherListMapper : Mapper<WeatherListResponse, WeatherList> {
    override fun mapDomain(input: WeatherListResponse): WeatherList = with(input) {
        WeatherList(
            weatherList = weatherList.map(WeatherMapper::mapDomain),
            webUrl = weatherDetailLink
        )
    }
}
