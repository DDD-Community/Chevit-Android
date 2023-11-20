package com.dkin.chevit.data.model.ext

import com.dkin.chevit.data.model.response.LocaleResponse
import java.util.Locale

internal fun LocaleResponse.getLocalizedText(): String {
    return when (Locale.getDefault().language) {
        "en" -> localeText.en
        else -> localeText.ko
    }
}
