package com.dkin.chevit.data.di.usecase

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.repository.PlanRepository
import com.dkin.chevit.domain.usecase.auth.GetUserStateUseCase
import com.dkin.chevit.domain.usecase.plan.CopyTemplateUseCase
import com.dkin.chevit.domain.usecase.plan.DeleteCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.DeleteCheckItemUseCase
import com.dkin.chevit.domain.usecase.plan.DeletePlanUseCase
import com.dkin.chevit.domain.usecase.plan.GetCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.GetMyPlanListUseCase
import com.dkin.chevit.domain.usecase.plan.GetNewsUseCase
import com.dkin.chevit.domain.usecase.plan.GetPlanUseCase
import com.dkin.chevit.domain.usecase.plan.GetTravelKindsListUseCase
import com.dkin.chevit.domain.usecase.plan.GetTravelWithListUseCase
import com.dkin.chevit.domain.usecase.plan.GetWeatherUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewCheckItemUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewScheduleUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewTemplateUseCase
import com.dkin.chevit.domain.usecase.plan.SearchCountryListUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateCheckItemCheckedUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateCheckItemUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateTemplateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object PlanUseCaseModule {
    @Provides
    fun provideCopyTemplateUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = CopyTemplateUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideDeleteCategoryUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = DeleteCategoryUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideDeleteCheckItemUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = DeleteCheckItemUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideDeletePlanUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = DeletePlanUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetCategoryUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetCategoryUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetMyPlanListUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetMyPlanListUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetNewsUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetNewsUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetPlanUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetPlanUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetTravelKindsListUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetTravelKindsListUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetTravelWithListUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetTravelWithListUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideGetWeatherUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = GetWeatherUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun providePostNewCategoryUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = PostNewCategoryUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun providePostNewCheckItemUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = PostNewCheckItemUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun providePostNewScheduleUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = PostNewScheduleUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun providePostNewTemplateUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = PostNewTemplateUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideSearchCountryListUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = SearchCountryListUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideUpdateCategoryUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = UpdateCategoryUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideUpdateCheckItemCheckedUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = UpdateCheckItemCheckedUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideUpdateCheckItemUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = UpdateCheckItemUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )

    @Provides
    fun provideUpdateTemplateUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        planRepository: PlanRepository,
    ) = UpdateTemplateUseCase(
        coroutineDispatcherProvider,
        planRepository,
    )
}
