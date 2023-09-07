package com.dkin.chevit.presentation.home

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.home.model.Template

sealed interface HomeIntent : ViewIntent {
    data class NoticeClicked(
        val checked: Boolean
    ) : HomeIntent

    object LogoutClicked : HomeIntent

    object WithdrawClicked : HomeIntent
}

@Stable
data class HomeState(
    val userName: String,
    val profileUrl: String,
    val checkList: List<CheckListItem>,
    val alarmEnabled: Boolean,
) : ViewState {
    data class CheckListItem(
        val id: Int,
        val title: String,
        val date: String,
        val isProgress: Boolean,
        val backgroundUrl: String,
    )

    companion object {
        fun empty(): HomeState =
            HomeState(
                userName = "",
                profileUrl = "",
                checkList = listOf(),
                alarmEnabled = false,
            )

        fun dummy(): HomeState =
            HomeState(
                userName = "민지",
                profileUrl = "",
                checkList = listOf(
                    CheckListItem(
                        id = 0,
                        title = "파리, 프랑스",
                        date = "2023.07.16 ~ 2023.07.20",
                        isProgress = true,
                        backgroundUrl = "",
                    ),
                ),
                alarmEnabled = false,
            )
    }
}

sealed interface HomeEffect : ViewEffect {
    object NavigateToAddCheckList : HomeEffect

    data class NavigateToCheckList(val id: Int) : HomeEffect

    object NavigateToProfileSetting : HomeEffect

    object NavigateToMyCheckList : HomeEffect

    object NavigateToTerms : HomeEffect

    object NavigateToNotificationSetting : HomeEffect

    object NavigateToAddTemplate : HomeEffect

    object NavigateToSortTemplate : HomeEffect
}

@Stable
sealed interface TemplateState {
    object EMPTY : TemplateState
    data class Available(
        val templateList: List<Template>
    ) : TemplateState
}