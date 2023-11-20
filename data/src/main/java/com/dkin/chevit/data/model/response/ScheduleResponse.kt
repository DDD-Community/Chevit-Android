package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ScheduleResponse(
    @SerialName("backgroundImageURL") val backgroundImageUrl: String,
    @SerialName("country") val country: LocaleResponse,
    @SerialName("startTime") val startTime: Long,
    @SerialName("endTime") val endTime: Long
) : DataModel
