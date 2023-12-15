package com.dkin.chevit.presentation.checklist.template

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.resource.TemplateColor

sealed interface BringTemplateIntent : ViewIntent {
    data class GetTemplate(val templateId: String) : BringTemplateIntent
    data class GetCategory(val templateId: String, val categoryId: String) : BringTemplateIntent
    data class BringTemplate(val templateId: String) : BringTemplateIntent
}

data class BringTemplateState(
    val planId: String,
    val templateList: List<Template>
) : ViewState {
    data class Template(
        val id: String,
        val title: String,
        val date: String,
        val colorType: TemplateColor
    )

    companion object {
        fun empty(): BringTemplateState = BringTemplateState(
            "", listOf()
        )

        fun dummy(): BringTemplateState = BringTemplateState(
            "", listOf(
                Template(
                    id = "0",
                    title = "자주 빠뜨리는 것",
                    date = "2023.08.10",
                    colorType = TemplateColor.DAWN
                ),
                Template(
                    id = "1",
                    title = "가족이랑 갈 때 필수템",
                    date = "2023.08.07",
                    colorType = TemplateColor.AFTERNOON
                ),
                Template(
                    id = "2",
                    title = "유럽 여행 갈 때",
                    date = "2023.08.05",
                    colorType = TemplateColor.MORNING
                ),
                Template(
                    id = "3",
                    title = "영상 촬영시 필요한 것들",
                    date = "2023.08.04",
                    colorType = TemplateColor.NIGHT
                ),
                Template(
                    id = "4",
                    title = "일본 갈 때 필수",
                    date = "2023.08.03",
                    colorType = TemplateColor.SUNSET
                ),
            )
        )
    }
}

sealed interface BringTemplateEffect : ViewEffect {
    object BringTemplateSuccess : BringTemplateEffect
    object BringTemplateFail : BringTemplateEffect
    object GetTemplateListFail : BringTemplateEffect
    object GetTemplateFail : BringTemplateEffect
    object GetCategoryFail : BringTemplateEffect
}