package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WeatherResponse(
    @SerialName("date") val date: DateResponse,
    @SerialName("icon") val iconUrl: String,
    @SerialName("temperature") val temp: TemperatureResponse,
) : DataModel
