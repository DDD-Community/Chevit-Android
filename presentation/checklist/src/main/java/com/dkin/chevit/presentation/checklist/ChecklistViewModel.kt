package com.dkin.chevit.presentation.checklist

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.common.category.CategoryType
import com.dkin.chevit.presentation.resource.TemplateColor
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ChecklistViewModel @Inject constructor() :
    MVIViewModel<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override fun createInitialState(): ChecklistState = ChecklistState.empty()

    override suspend fun processIntent(intent: ChecklistIntent) {
        when (intent) {
            is ChecklistIntent.ChangeTemplateOpenSetting -> {}
        }
    }

    fun getChecklist(id: String) {
        Timber.d("checklistId = $id")
    }

    fun onClickUrl(url: String) {
        setEffect { ChecklistEffect.NavigateToLink(url) }
    }

    fun onClickCategory(id: Int) {
        setEffect { ChecklistEffect.NavigateToCategory(id) }
    }

    fun bringTemplate() {
        setEffect { ChecklistEffect.NavigateToBringTemplate }
    }

    fun addCategory(title: String, category: CategoryType) {
        //TODO
    }

    fun saveTemplate(title: String, color: TemplateColor) {
        //TODO
    }
}