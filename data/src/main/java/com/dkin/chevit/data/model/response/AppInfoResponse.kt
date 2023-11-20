package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AppInfoResponse(
    @SerialName("termsOfServiceLink") val termsOfServiceLink: String,
    @SerialName("privacyPolicyLink") val privacyPolicyLink: String
) : DataModel
