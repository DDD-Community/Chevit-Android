package com.dkin.chevit.presentation.home

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface HomeIntent : ViewIntent {
    data class NoticeClicked(
        val checked: Boolean
    ) : HomeIntent
}

@Stable
data class HomeState(
    val userName: String,
    val profileUrl: String,
    val checkList: List<CheckListItem>,
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
            )
    }
}

sealed interface HomeEffect : ViewEffect {
    object NavigateToAddCheckList : HomeEffect

    data class NavigateToCheckList(val id: Int) : HomeEffect
}
