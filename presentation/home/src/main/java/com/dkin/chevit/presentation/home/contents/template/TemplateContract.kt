package com.dkin.chevit.presentation.home.contents.template

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.home.contents.template.model.Template
import com.dkin.chevit.presentation.resource.TemplateColor

sealed interface TemplateIntent : ViewIntent

@Stable
sealed interface TemplateState : ViewState {
    object EMPTY : TemplateState
    data class Available(
        val templateList: List<Template>
    ) : TemplateState

    companion object {
        fun dummy(): TemplateState = Available(
            listOf(
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
                Template(
                    id = "5",
                    title = "일본 갈 때 필수2",
                    date = "2023.08.02",
                    colorType = TemplateColor.DAWN
                ),
                Template(
                    id = "6",
                    title = "일본 갈 때 필수3",
                    date = "2023.08.01",
                    colorType = TemplateColor.AFTERNOON
                ),
            )
        )
    }
}

sealed interface TemplateEffect : ViewEffect {
    data class NavigateToTemplate(val id: String) : TemplateEffect
}