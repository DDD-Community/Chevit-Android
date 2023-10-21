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
    @SerialName("needSignUp") val needSignUp: Boolean = true
) : DataModel

internal fun UserResponse.toUser(token: String): UserState {
    return when {
        token.isBlank() -> UserState.Guest
        needSignUp -> UserState.NotRegister(token = token)
        else -> UserState.User(
            token = token,
            id = id,
            name = name,
            profileImageUrl = profileImageUrl
        )
    }
}
