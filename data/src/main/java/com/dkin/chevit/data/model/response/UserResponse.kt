package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserResponse(
    @SerialName("userId") val id: String,
    @SerialName("gender") val gender: GenderResponse,
    @SerialName("imageURL") val profileImageUrl: String,
    @SerialName("nickname") val name: String,
    @SerialName("needSignUp") val needSignUp: Boolean,
    @SerialName("yearOfBirth") val birthYear: Int,
) : DataModel
