package com.hodzi.alfabanktask.interactor

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.network.model.FeedApi
import io.reactivex.Observable

interface Interactor {
    fun getList(): Observable<FeedApi>

    fun saveFeed(list: List<FeedItemEntity>)
}
