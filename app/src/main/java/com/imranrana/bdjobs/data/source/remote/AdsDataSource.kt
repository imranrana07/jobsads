package com.imranrana.bdjobs.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.imranrana.bdjobs.data.api.ApiResponse
import com.imranrana.bdjobs.data.model.AdsData
import com.imranrana.bdjobs.utils.ApiException
import com.imranrana.bdjobs.utils.apiCall
import retrofit2.HttpException

class AdsDataSource : PagingSource<Int,AdsData>(){
    override fun getRefreshKey(state: PagingState<Int, AdsData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AdsData> {
        return try {
                val nextPage = params.key ?: 1
                val response = ApiResponse.getResult { apiCall?.getJobAds()!! }
                LoadResult.Page(
                    data = response.data,
                    prevKey = if (nextPage > 1) nextPage -1 else null,
                    nextKey = if (response.common.totalPages> nextPage) nextPage+1 else null
                )
            }catch (e:HttpException){
                LoadResult.Error(e)
            }catch (e:Exception){
                LoadResult.Error(e)
            }catch (e:ApiException){
                LoadResult.Error(e)
            }
        }
}