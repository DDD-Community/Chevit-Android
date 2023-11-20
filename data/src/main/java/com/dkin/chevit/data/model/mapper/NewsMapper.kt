package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.NewsResponse
import com.dkin.chevit.domain.model.News

internal object NewsMapper : Mapper<NewsResponse, News> {
    override fun mapDomain(input: NewsResponse): News = with(input) {
        News(title = title, webUrl = webUrl)
    }
}
