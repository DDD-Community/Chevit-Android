package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.OwnerResponse
import com.dkin.chevit.domain.model.UserState.User

internal object OwnerMapper : Mapper<OwnerResponse, User> {
    override fun mapDomain(input: OwnerResponse): User = with(input) {
        User(
            id = userId,
            name = nickname,
            profileImageUrl = imageURL,
            notificationEnabled = false
        )
    }
}
