package com.dkin.chevit.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GenderResponse {
    @SerialName("FEMALE")
    FEMALE,

    @SerialName("MALE")
    MALE,
}
