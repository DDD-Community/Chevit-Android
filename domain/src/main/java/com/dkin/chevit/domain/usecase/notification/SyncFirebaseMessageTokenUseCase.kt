package com.dkin.chevit.domain.usecase.notification

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.repository.NotificationRepository

class SyncFirebaseMessageTokenUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val notificationRepository: NotificationRepository,
    private val updatePushTokenUseCase: UpdatePushTokenUseCase
) : IOUseCase<Unit, None>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): None {
        val pushToken = notificationRepository.getPushToken()
        val param = UpdatePushTokenUseCase.Param(pushToken)
        updatePushTokenUseCase(param)
        return None
    }
}