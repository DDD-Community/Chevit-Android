package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.ScheduleResponse
import com.dkin.chevit.domain.model.Schedule
import java.time.LocalDateTime

internal object ScheduleMapper : Mapper<ScheduleResponse, Schedule> {
    override fun mapDomain(input: ScheduleResponse): Schedule = with(input) {
        Schedule(
            backgroundImageUrl = backgroundImageUrl,
            country = CountryMapper.mapDomain(country),
            startTime = FormattedTimeMapper.mapDomain(startTime),
            endTime = FormattedTimeMapper.mapDomain(endTime),
            isProgress = FormattedTimeMapper.mapLocalDate(endTime)?.isAfter(LocalDateTime.now())
                ?: false
        )
    }
}
