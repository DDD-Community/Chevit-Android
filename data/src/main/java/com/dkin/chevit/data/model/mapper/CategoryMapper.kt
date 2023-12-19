package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.CategoryResponse
import com.dkin.chevit.domain.model.Category

internal object CategoryMapper : Mapper<CategoryResponse, Category> {
    override fun mapDomain(input: CategoryResponse): Category = with(input) {
        Category(
            id = id,
            icon = CategoryIconTypeMapper.mapDomain(icon),
            subject = subject,
            createdTime = FormattedTimeMapper.mapCreatedTime(createdTime),
            checkedCount = checkedCount,
            checkList = checkList.map(CheckItemMapper::mapDomain)
        )
    }
}
