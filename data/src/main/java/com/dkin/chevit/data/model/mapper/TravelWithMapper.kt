package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.ext.getLocalizedText
import com.dkin.chevit.data.model.response.LocaleResponse
import com.dkin.chevit.domain.model.TravelWith

internal object TravelWithMapper : Mapper<LocaleResponse, TravelWith> {
    override fun mapDomain(input: LocaleResponse): TravelWith {
        return TravelWith(id = input.name, name = input.getLocalizedText())
    }
}
