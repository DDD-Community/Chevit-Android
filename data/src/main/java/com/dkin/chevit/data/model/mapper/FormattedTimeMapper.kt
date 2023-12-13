package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.domain.model.FormattedTime
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.util.Locale
import java.util.TimeZone


internal object FormattedTimeMapper {
    fun mapDomain(unixMillis: Long, format: String = "yyyy.MM.dd"): FormattedTime {
        val formatted = SimpleDateFormat(format, Locale.getDefault()).format(unixMillis)
        return FormattedTime(unixMillis = unixMillis, formatted = formatted)
    }

    fun mapLocalDate(unixMillis: Long): LocalDateTime? {
        return LocalDateTime.ofInstant(
            Instant.ofEpochMilli(unixMillis),
            TimeZone.getDefault().toZoneId()
        )
    }
}
