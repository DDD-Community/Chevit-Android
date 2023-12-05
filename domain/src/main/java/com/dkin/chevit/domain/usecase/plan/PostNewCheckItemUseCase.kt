package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.CheckItem
import com.dkin.chevit.domain.repository.PlanRepository

class PostNewCheckItemUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<PostNewCheckItemUseCase.Param, CheckItem>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): CheckItem {
        return planRepository.newCheckItem(
            planId = params.planId,
            categoryId = params.categoryId,
            content = params.content,
            memo = params.memo,
            quantity = params.quantity
        )
    }

    data class Param(
        val planId: String,
        val categoryId: String,
        val content: String,
        val memo: String,
        val quantity: Int
    )
}
