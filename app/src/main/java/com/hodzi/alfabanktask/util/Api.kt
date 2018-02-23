package com.hodzi.alfabanktask.util

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("_/rss/_rss.html")
    fun getList(
        @Query("subtype") subtype: Int = 1,
        @Query("category") category: Int = 1,
        @Query("city") city: Int = 21
    ): Observable<String>
}