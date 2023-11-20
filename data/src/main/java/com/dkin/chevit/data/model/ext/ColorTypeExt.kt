package com.dkin.chevit.data.model.ext

import com.dkin.chevit.data.model.type.ColorTypeResponse
import com.dkin.chevit.domain.model.ColorType
import com.dkin.chevit.domain.model.ColorType.AFTERNOON
import com.dkin.chevit.domain.model.ColorType.DAWN
import com.dkin.chevit.domain.model.ColorType.MORNING
import com.dkin.chevit.domain.model.ColorType.NIGHT
import com.dkin.chevit.domain.model.ColorType.SUNSET

internal fun ColorType.toResponse(): ColorTypeResponse = when (this) {
    DAWN -> ColorTypeResponse.DAWN
    MORNING -> ColorTypeResponse.MORNING
    AFTERNOON -> ColorTypeResponse.AFTERNOON
    SUNSET -> ColorTypeResponse.SUNSET
    NIGHT -> ColorTypeResponse.NIGHT
}
