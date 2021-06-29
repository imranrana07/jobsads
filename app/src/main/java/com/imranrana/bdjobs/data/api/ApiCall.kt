package com.imranrana.bdjobs.data.api

import com.imranrana.bdjobs.data.model.AdsData
import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {

    @GET("interviewtest/InterviewJson.json")
    suspend fun getJobAds():Response<BaseResponse<MutableList<AdsData>>>
}