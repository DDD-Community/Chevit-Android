package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.ext.getLocalizedText
import com.dkin.chevit.data.model.response.LocaleResponse
import com.dkin.chevit.domain.model.Country

internal object CountryMapper : Mapper<LocaleResponse, Country> {
    override fun mapDomain(input: LocaleResponse): Country = with(input) {
        Country(id = name, name = getLocalizedText())
    }
}
