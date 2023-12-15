package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.TemplateResponse
import com.dkin.chevit.domain.model.TemplateDetail

internal object TemplateMapper : Mapper<TemplateResponse, TemplateDetail> {
    override fun mapDomain(input: TemplateResponse): TemplateDetail = with(input) {
        TemplateDetail(
            colorType = color,
            subject = subject
        )
    }
}
