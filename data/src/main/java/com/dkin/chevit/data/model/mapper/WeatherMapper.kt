package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.WeatherResponse
import com.dkin.chevit.domain.model.Weather

internal object WeatherMapper : Mapper<WeatherResponse, Weather> {
    override fun mapDomain(input: WeatherResponse): Weather = with(input) {
        Weather(
            formattedTime = FormattedTimeMapper.mapDomain(date.unixMillis, "MM.dd"),
            iconUrl = iconUrl,
            temperature = temp.formatted ?: "",
        )
    }
}
