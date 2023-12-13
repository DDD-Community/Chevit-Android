package com.dkin.chevit.domain.repository

import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.Category
import com.dkin.chevit.domain.model.CategoryIconType
import com.dkin.chevit.domain.model.CheckItem
import com.dkin.chevit.domain.model.ColorType
import com.dkin.chevit.domain.model.Country
import com.dkin.chevit.domain.model.FormattedTime
import com.dkin.chevit.domain.model.News
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.PlanType
import com.dkin.chevit.domain.model.TravelKind
import com.dkin.chevit.domain.model.TravelWith
import com.dkin.chevit.domain.model.WeatherList

interface PlanRepository {
    suspend fun searchCountryList(query: String): DomainListModel<Country>

    suspend fun fetchTravelWithList(): DomainListModel<TravelWith>
    suspend fun fetchTravelKindsList(): DomainListModel<TravelKind>

    suspend fun postNewSchedule(
        country: Country,
        scheduleStartTime: Long,
        scheduleEndTime: Long,
        travelWith: List<String>,
        travelKind: List<String>,
        refPlanId: String?
    ): Plan

    suspend fun newTemplate(subject: String, color: ColorType, refPlanId: String?): Plan

    suspend fun fetchMyPlanList(deviceId: String, typ: PlanType): DomainListModel<Plan>

    suspend fun updateTemplate(planId: String, subject: String, color: ColorType): Plan

    suspend fun deletePlan(planId: String): None

    suspend fun fetchPlan(planId: String, deviceId: String, typ: PlanType): Plan

    suspend fun copyTemplate(planId: String, refPlanId: String?): Plan

    suspend fun fetchWeather(planId: String): WeatherList

    suspend fun fetchNews(planId: String): News

    suspend fun newCategory(planId: String, iconType: CategoryIconType, subject: String): Category

    suspend fun deleteCategory(planId: String, categoryId: String): None

    suspend fun fetchCategory(planId: String, categoryId: String): Category

    suspend fun updateCategory(
        planId: String,
        categoryId: String,
        iconType: CategoryIconType,
        subject: String
    ): Category

    suspend fun newCheckItem(
        planId: String,
        categoryId: String,
        content: String,
        memo: String,
        quantity: Int
    ): CheckItem

    suspend fun deleteCheckItem(planId: String, checkItemId: String): None

    suspend fun updateCheckItem(
        planId: String,
        checkItemId: String,
        content: String,
        memo: String,
        quantity: Int
    ): CheckItem

    suspend fun checkCheckItem(planId: String, checkItemId: String, checked: Boolean): CheckItem
}
