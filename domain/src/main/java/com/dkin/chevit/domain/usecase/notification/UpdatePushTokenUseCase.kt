package com.dkin.chevit.domain.usecase.notification

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.repository.NotificationRepository
import com.dkin.chevit.domain.usecase.notification.UpdatePushTokenUseCase.Param

class UpdatePushTokenUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val notificationRepository: NotificationRepository
) : IOUseCase<Param, None>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): None {
        return notificationRepository.updatePushToken(params.pushToken)
    }

    data class Param(val pushToken: String)
}
