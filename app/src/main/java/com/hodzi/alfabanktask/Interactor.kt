package com.hodzi.alfabanktask

import com.hodzi.alfabanktask.data.network.Api
import com.hodzi.alfabanktask.data.network.model.FeedApi
import com.hodzi.alfabanktask.utils.AlfaDatabase
import com.hodzi.alfabanktask.utils.AlfaExecutors
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Singleton

interface Interactor {
    fun getList(): Observable<FeedApi>
}

