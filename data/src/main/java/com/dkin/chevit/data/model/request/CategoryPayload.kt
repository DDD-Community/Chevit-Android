package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CategoryPayload(
    @SerialName("icon") val icon: CategoryIconTypeResponse,
    @SerialName("subject") val subject: String
) : DataModel
