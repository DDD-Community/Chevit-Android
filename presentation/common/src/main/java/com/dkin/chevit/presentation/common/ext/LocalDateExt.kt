package com.dkin.chevit.presentation.common.ext

import java.time.LocalDate
import java.time.ZoneOffset

fun LocalDate.unixMillis(): Long {
    return atStartOfDay().toEpochSecond(ZoneOffset.UTC)
}