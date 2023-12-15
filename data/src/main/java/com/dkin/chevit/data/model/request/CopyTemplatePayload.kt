package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.data.model.type.ColorTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CopyTemplatePayload(
    @SerialName("refPlanId") val refPlanId: String? = null
) : DataModel
