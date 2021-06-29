package com.imranrana.bdjobs.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eduworld.bdjobs.databinding.ItemAdsBinding

class AdsViewHolder(itemView: ItemAdsBinding): RecyclerView.ViewHolder(itemView.root) {
    val ivCompanyLogo = itemView.ivCompanyLogo
    val tvCompanyName = itemView.tvCompanyName
    val tvJobTitle = itemView.tvJobTitle
    val tvJobExperience = itemView.tvJobExperience
    val tvSalaryRange = itemView.tvSalaryRange
    val tvLastDate = itemView.tvLastDate
    val tvApplyInstruction = itemView.tvApplyInstruction
}
