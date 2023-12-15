package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CheckItemCheckedPayload(
    @SerialName("isCheck") val checked: Boolean,
) : DataModel
