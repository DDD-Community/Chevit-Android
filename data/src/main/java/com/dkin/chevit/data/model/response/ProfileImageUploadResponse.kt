package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProfileImageUploadResponse(
    @SerialName("uploadMethod") val uploadMethod: String = "",
    @SerialName("uploadURL") val uploadURL: String = "",
    @SerialName("imageURL") val imageURL: String = "",
) : DataModel