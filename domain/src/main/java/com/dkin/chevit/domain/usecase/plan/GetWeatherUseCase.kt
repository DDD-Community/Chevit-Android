package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.WeatherList
import com.dkin.chevit.domain.repository.PlanRepository

class GetWeatherUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<GetWeatherUseCase.Param, WeatherList>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): WeatherList {
        return planRepository.fetchWeather(params.planId)
    }

    data class Param(val planId: String)
}