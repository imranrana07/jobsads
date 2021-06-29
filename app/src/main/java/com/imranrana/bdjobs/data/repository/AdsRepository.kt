package com.imranrana.bdjobs.data.repository

import androidx.paging.*
import com.imranrana.bdjobs.data.model.AdsData
import com.imranrana.bdjobs.data.source.remote.AdsDataSource
import com.imranrana.bdjobs.utils.toNameDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AdsRepository {
    fun getAds(): Flow<PagingData<AdsData>>{
        return Pager(
            PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { AdsDataSource() }
        ).flow
    }
}