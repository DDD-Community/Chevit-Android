package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.home.model.Template
import com.dkin.chevit.presentation.home.model.TemplateColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    private val _templateState: MutableStateFlow<TemplateState> = MutableStateFlow(TemplateState.EMPTY)
    val templateState = _templateState.asStateFlow()

    init {
        _templateState.value = TemplateState.Available(
            listOf(
                Template(id = 0, title = "자주 빠뜨리는 것", date = "2023.08.10", colorType = TemplateColor.DAWN),
                Template(id = 1, title = "가족이랑 갈 때 필수템", date = "2023.08.07", colorType = TemplateColor.AFTERNOON),
                Template(id = 2, title = "유럽 여행 갈 때", date = "2023.08.05", colorType = TemplateColor.MORNING),
                Template(id = 3, title = "영상 촬영시 필요한 것들", date = "2023.08.04", colorType = TemplateColor.NIGHT),
                Template(id = 4, title = "일본 갈 때 필수", date = "2023.08.03", colorType = TemplateColor.SUNSET),
                Template(id = 5, title = "일본 갈 때 필수2", date = "2023.08.02", colorType = TemplateColor.DAWN),
                Template(id = 6, title = "일본 갈 때 필수3", date = "2023.08.01", colorType = TemplateColor.AFTERNOON),
            )
        )
    }

    override fun createInitialState(): HomeState = HomeState.empty()

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.NoticeClicked -> TODO()
            HomeIntent.LogoutClicked -> TODO()
            HomeIntent.WithdrawClicked -> TODO()
        }
    }

    fun onClickAddChecklist() {
        setEffect { HomeEffect.NavigateToAddCheckList }
    }

    fun onClickChecklist(id: Int) {
        setEffect { HomeEffect.NavigateToCheckList(id) }
    }

    fun onClickProfileSetting() {
        setEffect { HomeEffect.NavigateToProfileSetting }
    }

    fun onClickMyCheckList() {
        setEffect { HomeEffect.NavigateToMyCheckList }
    }

    fun onClickTerms() {
        setEffect { HomeEffect.NavigateToTerms }
    }

    fun onClickLogout() {
        launch { processIntent(HomeIntent.LogoutClicked) }
    }

    fun onClickWithdraw() {
        launch { processIntent(HomeIntent.WithdrawClicked) }
    }

    fun onClickAlarmEnabled(enabled: Boolean) {
        setState { copy(alarmEnabled = enabled) }
        launch {
            processIntent(HomeIntent.NoticeClicked(enabled))
        }
    }

    fun onClickNotificationSetting() {
        setEffect { HomeEffect.NavigateToNotificationSetting }
    }

    fun onClickAddTemplate() {
        setEffect { HomeEffect.NavigateToAddTemplate }
    }

    fun onClickSortTemplate() {
        setEffect { HomeEffect.NavigateToSortTemplate }
    }
}
