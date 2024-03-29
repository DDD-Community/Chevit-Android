package com.dkin.chevit.presentation.home.contents.template.model

import com.dkin.chevit.presentation.resource.TemplateColor

data class Template(
    val id: String,
    val title: String,
    val date: String,
    val colorType: TemplateColor
)
