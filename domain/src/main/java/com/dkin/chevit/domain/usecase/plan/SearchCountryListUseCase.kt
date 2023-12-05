package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Country
import com.dkin.chevit.domain.repository.PlanRepository

class SearchCountryListUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
): IOUseCase<SearchCountryListUseCase.Param, DomainListModel<Country>>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): DomainListModel<Country> {
        return planRepository.searchCountryList(params.query)
    }

    data class Param(val query: String)
}