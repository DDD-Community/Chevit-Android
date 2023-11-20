package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.data.model.type.ColorTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UpdateTemplatePayload(
    @SerialName("subject") val subject: String,
    @SerialName("color") val color: ColorTypeResponse
) : DataModel
