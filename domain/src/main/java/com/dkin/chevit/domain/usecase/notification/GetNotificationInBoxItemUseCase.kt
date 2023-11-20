package com.dkin.chevit.domain.usecase.notification

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Notification
import com.dkin.chevit.domain.repository.NotificationRepository

class GetNotificationInBoxItemUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val notificationRepository: NotificationRepository
) : IOUseCase<Unit, DomainListModel<Notification>>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): DomainListModel<Notification> {
        return notificationRepository.fetchNotificationList()
    }
}
