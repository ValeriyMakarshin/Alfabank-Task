package com.hodzi.alfabanktask.interactor.impl

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.mapper.ChannelMapper
import com.hodzi.alfabanktask.data.network.Api
import com.hodzi.alfabanktask.data.network.model.FeedApi
import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.utils.AlfaDatabase
import com.hodzi.alfabanktask.utils.AlfaExecutors
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InteractorImpl(val alfaExecutors: AlfaExecutors,
                     val alfaDatabase: AlfaDatabase,
                     val api: Api)
    : Interactor {
    override fun getDbList(): Flowable<List<FeedItemEntity>> {
        return alfaDatabase.feedItemDao().loadAllFeedItems()
    }

    override fun getList(): Observable<FeedApi> = api.getList()

    override fun saveFeed(list: List<FeedItemEntity>) {
        alfaExecutors.diskIO.execute({
            alfaDatabase.runInTransaction({
                alfaDatabase.feedItemDao().updateFeedItem(list)
            })
        })
    }

    override fun refresh() {
        getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val (_, list) = it.channelApi?.let { it1 -> ChannelMapper.transform(it1) }
                    ?: Pair(Any(), ArrayList<FeedItemEntity>())
                list
            }
            .subscribe({ saveFeed(it) })
    }
}
