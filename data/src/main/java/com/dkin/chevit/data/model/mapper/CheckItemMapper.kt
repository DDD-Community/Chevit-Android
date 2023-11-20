package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.CheckItemResponse
import com.dkin.chevit.domain.model.CheckItem

internal object CheckItemMapper : Mapper<CheckItemResponse, CheckItem> {
    override fun mapDomain(input: CheckItemResponse): CheckItem = with(input) {
        CheckItem(
            id = id,
            content = content,
            memo = memo,
            quantity = quantity,
            createdTime = FormattedTimeMapper.mapDomain(createdTime),
            checked = checked
        )
    }
}
