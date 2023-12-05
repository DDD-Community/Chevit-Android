package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.Category
import com.dkin.chevit.domain.repository.PlanRepository

class GetCategoryUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<GetCategoryUseCase.Param, Category>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Category {
        return planRepository.fetchCategory(params.planId, params.categoryId)
    }

    data class Param(
        val planId: String,
        val categoryId: String
    )
}