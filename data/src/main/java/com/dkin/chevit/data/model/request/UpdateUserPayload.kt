package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UpdateUserPayload(
    @SerialName("nickname") val name: String?,
    @SerialName("imageURL") val profileImage: String?
): DataModel
