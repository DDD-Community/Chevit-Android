package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TemperatureResponse(
    @SerialName("min") val min: Double,
    @SerialName("max") val max: Double,
    @SerialName("formatted") val formatted: String,
    @SerialName("value") val value: Double,
) : DataModel
