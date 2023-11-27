package com.dkin.chevit.presentation.home.contents.template.detail

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TemplateDetailViewModel @Inject constructor() :
    MVIViewModel<TemplateDetailIntent, TemplateDetailState, TemplateDetailEffect>() {
    override fun createInitialState(): TemplateDetailState = TemplateDetailState.dummy()

    override suspend fun processIntent(intent: TemplateDetailIntent) {
        when (intent) {
            is TemplateDetailIntent.ChangeTemplateOpenSetting -> {
                //todo
            }
        }
    }

    fun getTemplateList(planId: String) {
        //TODO
    }

    fun onClickAddCategory() {
        setEffect { TemplateDetailEffect.NavigateToAddCategory }
    }

    fun deleteCategory(planId: String, categoryId: String) {
        //todo
    }

    fun onClickCategory(id: String) {
        setEffect { TemplateDetailEffect.NavigateToChecklistDetail(id) }
    }
}