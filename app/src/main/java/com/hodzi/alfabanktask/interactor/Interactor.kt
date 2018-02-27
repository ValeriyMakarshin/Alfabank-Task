package com.hodzi.alfabanktask.interactor

import com.hodzi.alfabanktask.data.network.model.FeedApi
import io.reactivex.Observable

interface Interactor {
    fun getList(): Observable<FeedApi>
}
