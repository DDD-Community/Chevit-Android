package com.dkin.chevit.presentation.home.contents.notification

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.model.FormattedTime
import com.dkin.chevit.domain.usecase.notification.GetNotificationInBoxItemUseCase
import com.dkin.chevit.presentation.home.model.NotificationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NotificationListViewModel @Inject constructor(
    private val getNotificationList: GetNotificationInBoxItemUseCase
) : MVIViewModel<NotificationListIntent, NotificationListState, NotificationListEffect>() {
    override fun createInitialState(): NotificationListState = NotificationListState.Loading

    override suspend fun processIntent(intent: NotificationListIntent) {}

    fun initNotificationList() {
        viewModelScope.launch {
            kotlin.runCatching {
                getNotificationList(Unit).get()
            }.onSuccess {
                setState {
                    NotificationListState.Stable(
                        notificationList = it.list.map {
                            NotificationItem(
                                id = it.id,
                                subject = it.subject,
                                text = it.text,
                                time = it.time
                            )
                        }
                    )
                }
            }.onFailure { throwable ->
                Timber.e(throwable)
                setState {
                    NotificationListState.Error
                }
            }
        }
    }
}