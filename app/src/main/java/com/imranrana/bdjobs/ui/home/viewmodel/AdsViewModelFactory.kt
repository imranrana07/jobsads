package com.imranrana.bdjobs.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imranrana.bdjobs.data.repository.AdsRepository

@Suppress("UNCHECKED_CAST")
class AdsViewModelFactory(private val adsRepository: AdsRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AdsViewModel(adsRepository) as T
    }
}