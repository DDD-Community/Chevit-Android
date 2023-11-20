package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NewSchedulePayload(
    @SerialName("country") val country: String,
    @SerialName("scheduleStartTime") val scheduleStartTime: Long,
    @SerialName("scheduleEndTime") val scheduleEndTime: Long,
    @SerialName("travelWith") val travelWith: List<String>,
    @SerialName("travelKind") val travelKind: List<String>,
    @SerialName("refPlanId") val refPlanId: String? = null
) : DataModel
