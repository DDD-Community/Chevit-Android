package com.dkin.chevit.domain.usecase.notification

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.NotificationList
import com.dkin.chevit.domain.repository.NotificationRepository

class GetNotificationInBoxItemUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val notificationRepository: NotificationRepository
) : IOUseCase<Unit, NotificationList>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): NotificationList {
        return notificationRepository.fetchNotificationList()
    }
}
