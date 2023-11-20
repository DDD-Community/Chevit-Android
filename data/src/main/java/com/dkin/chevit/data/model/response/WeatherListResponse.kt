package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WeatherListResponse(
    @SerialName("weathers") val weatherList: List<WeatherResponse>,
    @SerialName("weatherDetailLink") val weatherDetailLink: String
) : DataModel
