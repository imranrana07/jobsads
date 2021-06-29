package com.imranrana.bdjobs.ui.home.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.eduworld.bdjobs.R
import com.eduworld.bdjobs.databinding.ItemAdsBinding
import com.imranrana.bdjobs.data.model.AdsData
import com.imranrana.bdjobs.utils.toNameDate

class AdsAdapter:PagingDataAdapter<AdsData,AdsViewHolder>(DiffUtilCallBack) {
    private lateinit var context: Context
    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        val adsData = getItem(position) as AdsData
        Glide.with(context).load(adsData.logo).placeholder(R.drawable.error_icon).into(holder.ivCompanyLogo)
        holder.tvCompanyName.text = adsData.jobDetails.companyName
        holder.tvJobTitle.text = adsData.jobDetails.title
        holder.tvJobExperience.text = experience(adsData.minExperience,adsData.maxExperience)
        holder.tvLastDate.text = toNameDate(adsData.deadline)
        holder.tvSalaryRange.text = salaryRange(adsData.minSalary,adsData.maxSalary)
        holder.tvApplyInstruction.text = HtmlCompat.fromHtml(adsData.jobDetails.applyInstruction,
            HtmlCompat.FROM_HTML_MODE_LEGACY)

        if (adsData.isFeatured){
            holder.itemView.setBackgroundColor(Color.BLUE)
        }else{
            holder.itemView.setBackgroundColor(Color.WHITE)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        context = parent.context
        val view = ItemAdsBinding.inflate(LayoutInflater.from(context),parent,false)
        return AdsViewHolder(view)
    }

    private object DiffUtilCallBack: DiffUtil.ItemCallback<AdsData>() {
        override fun areItemsTheSame(oldItem: AdsData, newItem: AdsData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AdsData, newItem: AdsData): Boolean {
            return oldItem == newItem
        }
    }

    private fun salaryRange(minSalary: String, maxSalary: String):String{
        return if (minSalary.isNotEmpty() && maxSalary.isNotEmpty()){
            "salary $minSalary ~ $maxSalary"
        }else if (minSalary.isNotEmpty()){
            "Min salary $minSalary "
        }else if (maxSalary.isNotEmpty()){
            "max salary $maxSalary "
        }else{
            "Salary Negotiable"
        }
    }

    private fun experience(minExp: Int, maxExp: Int):String{
        return if (minExp!= 0 && maxExp != 0){
            "Exp $minExp ~ $maxExp"
        }else if (minExp!= 0){
            "min Exp $minExp "
        }else if (maxExp != 0){
            "max Exp $maxExp "
        }else{
            "Exp not defined"
        }
    }
}