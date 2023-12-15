package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.ext.toResponse
import com.dkin.chevit.data.model.mapper.CategoryMapper
import com.dkin.chevit.data.model.mapper.CheckItemMapper
import com.dkin.chevit.data.model.mapper.CountryMapper
import com.dkin.chevit.data.model.mapper.NewsMapper
import com.dkin.chevit.data.model.mapper.PlanMapper
import com.dkin.chevit.data.model.mapper.TravelKindMapper
import com.dkin.chevit.data.model.mapper.TravelWithMapper
import com.dkin.chevit.data.model.mapper.WeatherListMapper
import com.dkin.chevit.data.model.mapper.mapDomainList
import com.dkin.chevit.data.model.request.CategoryPayload
import com.dkin.chevit.data.model.request.CheckItemCheckedPayload
import com.dkin.chevit.data.model.request.CheckItemPayload
import com.dkin.chevit.data.model.request.NewSchedulePayload
import com.dkin.chevit.data.model.request.NewTemplatePayload
import com.dkin.chevit.data.model.request.UpdateTemplatePayload
import com.dkin.chevit.data.remote.PlanAPI
import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.Category
import com.dkin.chevit.domain.model.CategoryIconType
import com.dkin.chevit.domain.model.CheckItem
import com.dkin.chevit.domain.model.ColorType
import com.dkin.chevit.domain.model.Country
import com.dkin.chevit.domain.model.News
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.PlanType
import com.dkin.chevit.domain.model.TravelKind
import com.dkin.chevit.domain.model.TravelWith
import com.dkin.chevit.domain.model.WeatherList
import com.dkin.chevit.domain.repository.PlanRepository
import javax.inject.Inject

internal class PlanRepositoryImpl @Inject constructor(
    private val planAPI: PlanAPI
) : PlanRepository {
    override suspend fun searchCountryList(query: String): DomainListModel<Country> {
        return planAPI.searchCountryList(query).mapDomainList(CountryMapper::mapDomain)
    }

    override suspend fun fetchTravelWithList(): DomainListModel<TravelWith> {
        return planAPI.fetchTravelWithList().mapDomainList(TravelWithMapper::mapDomain)
    }

    override suspend fun fetchTravelKindsList(): DomainListModel<TravelKind> {
        return planAPI.fetchTravelKindsList().mapDomainList(TravelKindMapper::mapDomain)
    }

    override suspend fun postNewSchedule(
        country: Country,
        scheduleStartTime: Long,
        scheduleEndTime: Long,
        travelWith: List<String>,
        travelKind: List<String>,
        refPlanId: String?
    ): Plan {
        val payload = NewSchedulePayload(
            country = country.id,
            scheduleStartTime = scheduleStartTime,
            scheduleEndTime = scheduleEndTime,
            travelWith = travelWith,
            travelKind = travelKind,
            refPlanId = refPlanId
        )
        return planAPI.postNewSchedule(payload).let(PlanMapper::mapDomain)
    }

    override suspend fun newTemplate(subject: String, color: ColorType, refPlanId: String?): Plan {
        val payload = NewTemplatePayload(
            subject = subject,
            color = color.toResponse(),
            refPlanId = refPlanId
        )
        return planAPI.newTemplate(payload).let(PlanMapper::mapDomain)
    }

    override suspend fun fetchMyPlanList(typ: PlanType): DomainListModel<Plan> {
        return planAPI.fetchMyPlanList(typ.name).mapDomainList(PlanMapper::mapDomain)
    }

    override suspend fun updateTemplate(planId: String, subject: String, color: ColorType): Plan {
        val payload = UpdateTemplatePayload(
            subject = subject,
            color = color.toResponse()
        )
        return planAPI.updateTemplate(planId, payload).let(PlanMapper::mapDomain)
    }

    override suspend fun deletePlan(planId: String): None {
        planAPI.deletePlan(planId)
        return None
    }

    override suspend fun fetchPlan(planId: String, typ: PlanType): Plan {
        return planAPI.fetchPlan(planId, typ.name).let(PlanMapper::mapDomain)
    }

    override suspend fun copyTemplate(planId: String, refPlanId: String?): Plan {
        return planAPI.copyTemplate(planId, refPlanId).let(PlanMapper::mapDomain)
    }

    override suspend fun fetchWeather(planId: String): WeatherList {
        return planAPI.fetchWeather(planId).let(WeatherListMapper::mapDomain)
    }

    override suspend fun fetchNews(planId: String): News {
        return planAPI.fetchNews(planId).let(NewsMapper::mapDomain)
    }

    override suspend fun newCategory(
        planId: String,
        iconType: CategoryIconType,
        subject: String
    ): Category {
        val payload = CategoryPayload(
            icon = iconType.toResponse(),
            subject = subject
        )
        return planAPI.newCategory(planId, payload).let(CategoryMapper::mapDomain)
    }

    override suspend fun deleteCategory(planId: String, categoryId: String): None {
        planAPI.deleteCategory(planId, categoryId)
        return None
    }

    override suspend fun fetchCategory(planId: String, categoryId: String): Category {
        return planAPI.fetchCategory(planId, categoryId).let(CategoryMapper::mapDomain)
    }

    override suspend fun updateCategory(
        planId: String,
        categoryId: String,
        iconType: CategoryIconType,
        subject: String
    ): Category {
        val payload = CategoryPayload(
            icon = iconType.toResponse(),
            subject = subject
        )
        return planAPI.updateCategory(planId, categoryId, payload).let(CategoryMapper::mapDomain)
    }

    override suspend fun newCheckItem(
        planId: String,
        categoryId: String,
        content: String,
        memo: String,
        quantity: Int
    ): CheckItem {
        val payload = CheckItemPayload(
            content = content,
            memo = memo,
            quantity = quantity
        )
        return planAPI.newCheckItem(planId, categoryId, payload).let(CheckItemMapper::mapDomain)
    }

    override suspend fun deleteCheckItem(planId: String, checkItemId: String): None {
        planAPI.deleteCheckItem(planId, checkItemId)
        return None
    }

    override suspend fun updateCheckItem(
        planId: String,
        checkItemId: String,
        content: String,
        memo: String,
        quantity: Int
    ): CheckItem {
        val payload = CheckItemPayload(
            content = content,
            memo = memo,
            quantity = quantity
        )
        return planAPI.updateCheckItem(planId, checkItemId, payload).let(CheckItemMapper::mapDomain)
    }

    override suspend fun checkCheckItem(
        planId: String,
        checkItemId: String,
        checked: Boolean
    ): CheckItem {
        val payload = CheckItemCheckedPayload(checked)
        return planAPI.checkCheckItem(planId, checkItemId, payload).let(CheckItemMapper::mapDomain)
    }
}
