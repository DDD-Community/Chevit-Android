package com.dkin.chevit.presentation.home

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.home.model.CheckListItem

sealed interface HomeIntent : ViewIntent {
    object ViewCreated : HomeIntent
    data class NoticeClicked(
        val checked: Boolean
    ) : HomeIntent
}

@Stable
sealed interface HomeState : ViewState {
    object Loading : HomeState

    data class Stable(
        val userName: String = "",
        val profileUrl: String = "",
        val checkList: List<CheckListItem>,
    ) : HomeState {
        companion object {
            fun empty(): Stable =
                Stable(
                    userName = "",
                    profileUrl = "",
                    checkList = listOf(),
                )

            fun dummy(): HomeState =
                Stable(
                    userName = "민지",
                    profileUrl = "",
                    checkList = listOf(
                        CheckListItem(
                            id = "0",
                            title = "파리, 프랑스",
                            date = "2023.07.16 ~ 2023.07.20",
                            isProgress = true,
                            backgroundUrl = "",
                        ),
                        CheckListItem(
                            id = "1",
                            title = "오사카, 일본",
                            date = "2023.07.10 ~ 2023.07.12",
                            isProgress = true,
                            backgroundUrl = "",
                        ),
                        CheckListItem(
                            id = "2",
                            title = "토론토, 캐나다",
                            date = "2023.07.01 ~ 2023.07.10",
                            isProgress = true,
                            backgroundUrl = "",
                        ),
                    ),
                )
        }
    }
}

sealed interface HomeEffect : ViewEffect {
    object NavigateToAddCheckList : HomeEffect

    data class NavigateToCheckList(val id: String) : HomeEffect
}
