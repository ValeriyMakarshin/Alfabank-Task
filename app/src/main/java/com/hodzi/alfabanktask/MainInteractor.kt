package com.hodzi.alfabanktask

import com.hodzi.alfabanktask.data.network.Api
import com.hodzi.alfabanktask.data.network.model.FeedApi
import com.hodzi.alfabanktask.utils.AlfaDatabase
import com.hodzi.alfabanktask.utils.AlfaExecutors
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainInteractor @Inject constructor(val alfaExecutors: AlfaExecutors,
                                         val alfaDatabase: AlfaDatabase,
                                         val api: Api) {

    fun getList(): Observable<FeedApi> = api.getList()
}
