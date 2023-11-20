package com.dkin.chevit.data.model.type

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class PlanTypeResponse : DataModel {
    @SerialName("SCHEDULE")
    SCHEDULE,

    @SerialName("TEMPLATE")
    TEMPLATE;
}
