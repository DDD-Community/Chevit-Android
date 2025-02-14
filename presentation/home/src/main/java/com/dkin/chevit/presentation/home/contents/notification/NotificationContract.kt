package com.dkin.chevit.presentation.home.contents.notification

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.domain.model.FormattedTime
import com.dkin.chevit.presentation.home.model.NotificationItem

sealed interface NotificationListIntent : ViewIntent

@Stable
sealed interface NotificationListState : ViewState {
    object Loading : NotificationListState
    data class Stable(
        val notificationList: List<NotificationItem>,
        val nextCursor: String? = null
    ) : NotificationListState {
        companion object {
            fun dummy(): Stable = Stable(
                notificationList = listOf(
                    NotificationItem(
                        id = 0,
                        subject = "D-1 파리, 프랑스",
                        text = "여행 전, 준비물은 다 챙기셨나요?",
                        time = FormattedTime(unixMillis = 0, formatted = "2022.07.16")
                    ),
                    NotificationItem(
                        id = 0,
                        subject = "D-3 파리, 프랑스",
                        text = "아직 챙기지 못한 준비물이 있어요!",
                        time = FormattedTime(unixMillis = 0, formatted = "2022.07.14")
                    ),
                )
            )
        }
    }
    object Error : NotificationListState
}


sealed interface NotificationListEffect : ViewEffect
