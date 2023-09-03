package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {
    override fun createInitialState(): HomeState = HomeState.empty()

    override suspend fun processIntent(intent: HomeIntent) {
    }

    fun onClickAddChecklist() {

    }

    fun onClickChecklist(id: Int) {

    }
}
