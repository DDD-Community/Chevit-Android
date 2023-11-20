package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class OwnerResponse(
    @SerialName("userId") val userId: String,
    @SerialName("nickname") val nickname: String,
    @SerialName("imageURL") val imageURL: String,
) : DataModel
