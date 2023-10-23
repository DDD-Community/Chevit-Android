package com.dkin.chevit.domain.usecase.notification

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.NotificationSetting
import com.dkin.chevit.domain.repository.NotificationRepository
import com.dkin.chevit.domain.usecase.notification.UpdateNotificationEnableStateUseCase.Param

class UpdateNotificationEnableStateUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val notificationRepository: NotificationRepository
) : IOUseCase<Param, NotificationSetting>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): NotificationSetting {
        return notificationRepository.updateNotificationPushEnabled(params.notificationEnabled)
    }

    data class Param(val notificationEnabled: Boolean)
}
