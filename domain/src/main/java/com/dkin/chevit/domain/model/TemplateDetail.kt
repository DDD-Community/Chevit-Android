package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class TemplateDetail(
    val colorType: ColorType,
    val subject: String
) : DomainModel