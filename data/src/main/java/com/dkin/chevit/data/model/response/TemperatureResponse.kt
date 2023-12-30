package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TemperatureResponse(
    @SerialName("min") val min: String? = "",
    @SerialName("max") val max: String? = "",
    @SerialName("formatted") val formatted: String? = "",
    @SerialName("value") val value: String? = "",
) : DataModel
