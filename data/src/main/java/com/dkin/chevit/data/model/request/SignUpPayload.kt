package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SignUpPayload(
    @SerialName("nickname") val name: String,
    @SerialName("yearOfBirth") val birthYear: Int,
    @SerialName("gender") val gender: String,
) : DataModel
