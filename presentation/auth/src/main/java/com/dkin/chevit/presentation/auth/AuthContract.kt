package com.dkin.chevit.presentation.auth

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface AuthIntent : ViewIntent {
    object NextClicked : AuthIntent

    @JvmInline
    value class SelectedIntro(val position: Int) : AuthIntent
}

data class AuthState(
    val selectedIntroGuideIndex: Int = 0,
    val introGuideList: List<IntroPagerUiModel> = listOf(
        IntroPagerUiModel(
            id = 0,
            imageRes = R.drawable.illust_onboard_1,
            title = "체크리스트 작성 및 추천",
            description = "체빗이 추천하는 체크리스트와\n함께 여행 계획을 세워요",
        ),
        IntroPagerUiModel(
            id = 1,
            imageRes = R.drawable.illust_onboard_2,
            title = "체크리스트 열람",
            description = "다른 사람의 체크리스트를\n볼 수 있어요",
        ),
        IntroPagerUiModel(
            id = 2,
            imageRes = R.drawable.illust_onboard_3,
            title = "나만의 템플릿",
            description = "자주 사용하는 나만의 템플릿을\n만들고 관리할 수 있어요",
        ),
    ),
) : ViewState {
    val title: String
        get() = introGuideList.getOrNull(selectedIntroGuideIndex)?.title.orEmpty()
    val description: String
        get() = introGuideList.getOrNull(selectedIntroGuideIndex)?.description.orEmpty()
    val nextButtonText: String
        get() = when (selectedIntroGuideIndex) {
            introGuideList.lastIndex -> "시작하기"
            else -> "다음"
        }
}

sealed interface AuthEffect : ViewEffect {
    object NavigateSignIn : AuthEffect
}
