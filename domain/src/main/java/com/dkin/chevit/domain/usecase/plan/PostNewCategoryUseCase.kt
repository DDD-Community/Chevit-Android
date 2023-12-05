package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Category
import com.dkin.chevit.domain.model.getCategoryIconTypeByName
import com.dkin.chevit.domain.repository.PlanRepository

class PostNewCategoryUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<PostNewCategoryUseCase.Param, Category>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Category {
        return planRepository.newCategory(
            planId = params.planId,
            iconType = params.iconType.getCategoryIconTypeByName(),
            subject = params.subject
        )
    }

    data class Param(
        val planId: String,
        val iconType: String,
        val subject: String
    )
}
