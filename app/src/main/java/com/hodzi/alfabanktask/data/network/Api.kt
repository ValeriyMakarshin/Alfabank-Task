package com.hodzi.alfabanktask.data.network

import com.hodzi.alfabanktask.data.network.model.FeedApi
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    companion object {
        const val DEFAULT_SUBTYPE: Int = 1
        const val DEFAULT_CATEGORY: Int = 2
        const val DEFAULT_CITY: Int = 21
    }

    @GET("_/rss/_rss.html")
    fun getList(
        @Query("subtype") subtype: Int = DEFAULT_SUBTYPE,
        @Query("category") category: Int = DEFAULT_CATEGORY,
        @Query("city") city: Int = DEFAULT_CITY
    ): Observable<FeedApi>
}
