package com.dkin.chevit.domain.usecase.notification

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.NotificationSetting
import com.dkin.chevit.domain.model.UserState.Guest
import com.dkin.chevit.domain.model.UserState.NotRegister
import com.dkin.chevit.domain.model.UserState.User
import com.dkin.chevit.domain.repository.AuthRepository

class GetNotificationSettingUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository
) : IOUseCase<Unit, NotificationSetting>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): NotificationSetting {
        val notificationEnabled = when (val user = authRepository.getUserState()) {
            is User -> user.notificationEnabled
            Guest, NotRegister -> false
        }
        return NotificationSetting(notificationEnabled = notificationEnabled)
    }
}
