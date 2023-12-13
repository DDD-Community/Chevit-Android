package com.dkin.chevit.data.remote

import com.dkin.chevit.data.model.request.CategoryPayload
import com.dkin.chevit.data.model.request.CheckItemPayload
import com.dkin.chevit.data.model.request.NewSchedulePayload
import com.dkin.chevit.data.model.request.NewTemplatePayload
import com.dkin.chevit.data.model.request.UpdateTemplatePayload
import com.dkin.chevit.data.model.response.CategoryResponse
import com.dkin.chevit.data.model.response.CheckItemResponse
import com.dkin.chevit.data.model.response.LocaleResponse
import com.dkin.chevit.data.model.response.NewsResponse
import com.dkin.chevit.data.model.response.PlanResponse
import com.dkin.chevit.data.model.response.WeatherListResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 체크리스트 관련 API
 */
internal interface PlanAPI {
    /**
     * 여행 국가 검색
     */
    @GET("searchCountry")
    suspend fun searchCountryList(@Query("q") query: String): List<LocaleResponse>

    /**
     * 여행 동반자 목록
     */
    @GET("fetchAllTravelWith")
    suspend fun fetchTravelWithList(): List<LocaleResponse>

    /**
     * 여행 유형 목록
     */
    @GET("fetchAllTravelKinds")
    suspend fun fetchTravelKindsList(): List<LocaleResponse>

    /**
     * 새 체크리스트 생성
     */
    @POST("newSchedule")
    suspend fun postNewSchedule(@Body body: NewSchedulePayload): PlanResponse

    /**
     * 새 템플릿 생성
     */
    @POST("newTemplate")
    suspend fun newTemplate(@Body body: NewTemplatePayload): PlanResponse

    /**
     * 내 계획 (체크리스트 or 템플릿) 목록 가져오기
     */
    @GET("fetchMyPlanList")
    suspend fun fetchMyPlanList(
        @Query("Device-Id") deviceId: String,
        @Query("typ") typ: String
    ): List<PlanResponse>

    /**
     * 내 계획 (체크리스트 or 템플릿) 목록 수정
     */
    @PUT("updateTemplate/{planId}")
    suspend fun updateTemplate(
        @Path("planId") planId: String,
        @Body body: UpdateTemplatePayload
    ): PlanResponse


    /**
     * 내 계획 (체크리스트 or 템플릿) 목록 삭제
     */
    @DELETE("plan/{planId}")
    suspend fun deletePlan(@Path("planId") planId: String)

    /**
     * 여행 계획 "단" 한개 가져오기
     */
    @GET("plan/{planId}")
    suspend fun fetchPlan(
        @Path("planId") planId: String,
        @Query("Device-Id") deviceId: String,
        @Query("typ") typ: String
    ): PlanResponse

    /**
     * 여행 계획에 템플릿 덮어쓰기 (계획 <- 템플릿)
     */
    @PUT("plan/{planId}/copyTemplate")
    suspend fun copyTemplate(
        @Path("planId") planId: String,
        @Field("refPlanId") refPlanId: String?
    ): PlanResponse

    /**
     * 여행 계획에 대한 날씨 정보 가져오기
     */
    @GET("plan/{planId}/weather")
    suspend fun fetchWeather(@Path("planId") planId: String): WeatherListResponse

    /**
     * 여행 계획에 대한 안전 알림(뉴스) 정보 가져오기
     */
    @GET("plan/{planId}/safetyNews")
    suspend fun fetchNews(@Path("planId") planId: String): NewsResponse

    /**
     * 새 카테고리 추가
     */
    @POST("plan/{planId}/newCategory")
    suspend fun newCategory(
        @Path("planId") planId: String,
        @Body body: CategoryPayload
    ): CategoryResponse

    /**
     * 카테고리 삭제
     */
    @DELETE("plan/{planId}/category/{categoryId}")
    suspend fun deleteCategory(
        @Path("planId") planId: String,
        @Path("categoryId") categoryId: String
    )

    /**
     * 단일 카테고리 가져오기
     */
    @GET("plan/{planId}/category/{categoryId}")
    suspend fun fetchCategory(
        @Path("planId") planId: String,
        @Path("categoryId") categoryId: String
    ): CategoryResponse

    /**
     * 카테고리 업데이트
     */
    @PUT("plan/{planId}/category/{categoryId}")
    suspend fun updateCategory(
        @Path("planId") planId: String,
        @Path("categoryId") categoryId: String,
        @Body body: CategoryPayload
    ): CategoryResponse

    /**
     * 새 체크리스트 아이템 추가
     */
    @POST("plan/{planId}/category/{categoryId}/newCheckItem")
    suspend fun newCheckItem(
        @Path("planId") planId: String,
        @Path("categoryId") categoryId: String,
        @Body body: CheckItemPayload
    ): CheckItemResponse

    /**
     * 체크리스트 아이템 삭제
     */
    @DELETE("plan/{planId}/checkItem/{checkItemId}")
    suspend fun deleteCheckItem(
        @Path("planId") planId: String,
        @Path("checkItemId") checkItemId: String
    )

    /**
     * 체크리스트 아이템 업데이트
     */
    @PUT("plan/{planId}/checkItem/{checkItemId}")
    suspend fun updateCheckItem(
        @Path("planId") planId: String,
        @Path("checkItemId") checkItemId: String,
        @Body body: CheckItemPayload
    ): CheckItemResponse

    /**
     * 체크리스트 아이템 체크 상태 변경
     */
    @PATCH("plan/{planId}/checkItem/{checkItemId}/checked")
    suspend fun checkCheckItem(
        @Path("planId") planId: String,
        @Path("checkItemId") checkItemId: String,
        @Field("isCheck") checked: Boolean
    ): CheckItemResponse
}
