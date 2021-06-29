package com.imranrana.bdjobs.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AdsData(
    val jobTitle: String,
    var deadline: String,
    @SerializedName("recruitingCompany'sProfile")
    val recruitingCompanyProfile: String,
    val jobDetails: JobDetails,
    val logo: String,
    @SerializedName("IsFeatured")
    val isFeatured: Boolean,
    val minExperience: Int,
    val maxExperience: Int,
    val minSalary: String,
    val maxSalary: String,
):Serializable{
    data class JobDetails(
        @SerializedName("Title")
        val title: String,
        @SerializedName("LastDate")
        var lastDate: String,
        @SerializedName("CompanyName")
        val companyName: String,
        @SerializedName("ApplyInstruction")
        val applyInstruction: String
    )
}