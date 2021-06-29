package com.imranrana.bdjobs.utils

import com.imranrana.bdjobs.data.api.ApiCall
import com.imranrana.bdjobs.data.api.RetrofitClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

const val BASE_URL = "http://corporate3.bdjobs.com"

val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
class ApiException(message: String): IOException(message)
val apiCall = RetrofitClient.retrofit?.create(ApiCall::class.java)