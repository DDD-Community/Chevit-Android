package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CheckItemResponse(
    @SerialName("checkItemId") val id: String,
    @SerialName("content") val content: String,
    @SerialName("memo") val memo: String,
    @SerialName("quantity") val quantity: Int,
    @SerialName("createdTime") val createdTime: Long,
    @SerialName("checked") val checked: Boolean
) : DataModel
