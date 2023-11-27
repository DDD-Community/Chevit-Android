package com.dkin.chevit.presentation.checklist.category

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.common.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor() :
    MVIViewModel<AddCategoryIntent, AddCategoryState, AddCategoryEffect>() {
    override fun createInitialState(): AddCategoryState = AddCategoryState.empty()

    override suspend fun processIntent(intent: AddCategoryIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun saveCategory(title: String, category: CategoryType) {
        //todo
    }
}