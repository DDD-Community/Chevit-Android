package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ValidationNicknamePayload(
    @SerialName("nickname") val name: String,
) : DataModel
