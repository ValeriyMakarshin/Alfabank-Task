package com.hodzi.alfabanktask.interactor.impl

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.network.Api
import com.hodzi.alfabanktask.data.network.model.FeedApi
import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.utils.AlfaDatabase
import com.hodzi.alfabanktask.utils.AlfaExecutors
import io.reactivex.Observable

class InteractorImpl(val alfaExecutors: AlfaExecutors,
                     val alfaDatabase: AlfaDatabase,
                     val api: Api)
    : Interactor {

    override fun getList(): Observable<FeedApi> = api.getList()

    override fun saveFeed(list: List<FeedItemEntity>) {
        alfaExecutors.diskIO.execute({
            alfaDatabase.runInTransaction({
                alfaDatabase.feedItemDao().insertAll(list)
            })
        })
    }


}
