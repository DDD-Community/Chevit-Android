package com.dkin.chevit.presentation.common.ext

import java.time.LocalDate
import java.time.ZoneId

fun LocalDate.unixMillis(): Long {
    return atStartOfDay(ZoneId.systemDefault()).toEpochSecond()
}