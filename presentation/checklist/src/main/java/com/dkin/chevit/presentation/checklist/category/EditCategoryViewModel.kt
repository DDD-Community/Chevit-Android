package com.dkin.chevit.presentation.checklist.category

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.common.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditCategoryViewModel @Inject constructor() :
    MVIViewModel<EditCategoryIntent, EditCategoryState, EditCategoryEffect>() {
    override fun createInitialState(): EditCategoryState = EditCategoryState.empty()

    override suspend fun processIntent(intent: EditCategoryIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun initState(planId: String,categoryId: String, title: String, type: CategoryType) {
        setState {
            EditCategoryState(planId, categoryId, title, type)
        }
    }

    fun saveCategory(title: String, category: CategoryType) {
        //todo
    }
}