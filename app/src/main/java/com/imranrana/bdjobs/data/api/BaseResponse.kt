package com.imranrana.bdjobs.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BaseResponse<T> (
    @SerializedName("statuscode")
    val statusCode: Int,
    val message: String,
    val data: T,
    val common: Common
):Serializable{
    data class Common(
        @SerializedName("total_records_found")
        val totalRecords: Int,
        @SerializedName("totalpages")
        val totalPages: Int
    )
}