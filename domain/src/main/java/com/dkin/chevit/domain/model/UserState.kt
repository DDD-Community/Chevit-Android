package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

sealed interface UserState : DomainModel {
    object Guest : UserState

    @JvmInline
    value class NotRegister(val token: String) : UserState

    data class User(
        val token: String,
        val id: String,
        val name: String,
        val gender: Gender,
        val birthYear: String,
        val profileImageUrl: String,
    ) : UserState
}
