package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.domain.model.UserState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserResponse(
    @SerialName("userId") val id: String = "",
    @SerialName("nickname") val name: String = "",
    @SerialName("imageURL") val profileImageUrl: String = "",
    @SerialName("isNotificationAllowed") val notificationEnabled: Boolean = false,
    @SerialName("needSignUp") val needSignUp: Boolean = true
) : DataModel

internal fun UserResponse.toUser(): UserState {
    return when {
        needSignUp -> UserState.NotRegister
        else -> UserState.User(
            id = id,
            name = name,
            profileImageUrl = profileImageUrl,
            notificationEnabled = notificationEnabled
        )
    }
}
