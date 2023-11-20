package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CheckItemPayload(
    @SerialName("content") val content: String,
    @SerialName("memo") val memo: String,
    @SerialName("quantity") val quantity: Int
) : DataModel
