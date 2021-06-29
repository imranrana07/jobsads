package com.imranrana.bdjobs.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.imranrana.bdjobs.data.model.AdsData
import com.imranrana.bdjobs.data.repository.AdsRepository
import com.imranrana.bdjobs.utils.reformatDate
import com.imranrana.bdjobs.utils.toNameDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transformLatest

class AdsViewModel(private val adsRepository: AdsRepository): ViewModel() {
    val success:Flow<PagingData<AdsData>>? = null

    fun getAds():Flow<PagingData<AdsData>>{
        return adsRepository.getAds()
    }
}