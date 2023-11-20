package com.dkin.chevit.data.model.type

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class ColorTypeResponse : DataModel {
    @SerialName("DAWN")
    DAWN,

    @SerialName("MORNING")
    MORNING,

    @SerialName("AFTERNOON")
    AFTERNOON,

    @SerialName("SUNSET")
    SUNSET,

    @SerialName("NIGHT")
    NIGHT;
}
