package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.domain.model.ColorType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TemplateResponse(
    @SerialName("color") val color: ColorType,
    @SerialName("subject") val subject: String
) : DataModel