package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProfileImageUploadPayload(
    @SerialName("fileSize") val fileSize: Int,
    @SerialName("mimeType") val mimeType: String,
) : DataModel
