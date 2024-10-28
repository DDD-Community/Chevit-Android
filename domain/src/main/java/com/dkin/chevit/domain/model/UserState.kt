package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

sealed interface UserState : DomainModel {
    object Guest : UserState

    object NotRegister : UserState

    data class User(
        val id: String,
        val name: String,
        val profileImageUrl: String,
        val notificationEnabled: Boolean
    ) : UserState
}
