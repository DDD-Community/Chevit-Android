package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.News
import com.dkin.chevit.domain.repository.PlanRepository

class GetNewsUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<GetNewsUseCase.Param, News>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): News {
        return planRepository.fetchNews(params.planId)
    }

    data class Param(val planId: String)
}