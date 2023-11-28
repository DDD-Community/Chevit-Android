package com.dkin.chevit.presentation.checklist.template

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailState
import com.dkin.chevit.presentation.checklist.main.ChecklistState
import com.dkin.chevit.presentation.checklist.template.model.TemplateCategoryDetailState
import com.dkin.chevit.presentation.checklist.template.model.TemplateDetailState
import com.dkin.chevit.presentation.common.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BringTemplateViewModel @Inject constructor() :
    MVIViewModel<BringTemplateIntent, BringTemplateState, BringTemplateEffect>() {
    override fun createInitialState() = BringTemplateState.dummy()

    override suspend fun processIntent(intent: BringTemplateIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun setPlanId(planId: String) {
        setState {
            copy(planId = planId)
        }
    }

    fun bringTemplate(templateId: String) {
        //todo
        setEffect { BringTemplateEffect.BringTemplateSuccess }
    }

    fun getTemplateDetail(templateId: String): TemplateDetailState {
        //todo
        return TemplateDetailState(
            "가족이랑 갈 때 필수템",
            listOf(
                ChecklistState.Category(
                    categoryId = "0",
                    title = CategoryType.REQUIRES.title,
                    categoryType = CategoryType.REQUIRES,
                    checked = 12,
                    total = 32
                ),
                ChecklistState.Category(
                    categoryId = "1",
                    title = CategoryType.TOILETRIES.title,
                    categoryType = CategoryType.TOILETRIES,
                    checked = 24,
                    total = 24
                ),
                ChecklistState.Category(
                    categoryId = "2",
                    title = CategoryType.CLOTHES.title,
                    categoryType = CategoryType.CLOTHES,
                    checked = 24,
                    total = 24
                ),
            )
        )
    }

    fun getChecklistDetailItems(
        templateId: String,
        categoryId: String
    ): TemplateCategoryDetailState {
        //todo
        return TemplateCategoryDetailState(
            "작은 소지품",
            listOf(
                ChecklistDetailState.ChecklistDetailItem(
                    id = "0",
                    checked = true,
                    title = "여권",
                    memo = "",
                    count = 1
                ),
                ChecklistDetailState.ChecklistDetailItem(
                    id = "1",
                    checked = true,
                    title = "항공권",
                    memo = "프린트하기",
                    count = 1
                ),
                ChecklistDetailState.ChecklistDetailItem(
                    id = "2",
                    checked = false,
                    title = "여행자보험",
                    memo = "프린트하기",
                    count = 1
                ),
            )
        )
    }
}