package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.ext.getLocalizedText
import com.dkin.chevit.data.model.response.LocaleResponse
import com.dkin.chevit.domain.model.TravelKind

internal object TravelKindMapper : Mapper<LocaleResponse, TravelKind> {
    override fun mapDomain(input: LocaleResponse): TravelKind {
        return TravelKind(id = input.name, name = input.getLocalizedText())
    }
}
