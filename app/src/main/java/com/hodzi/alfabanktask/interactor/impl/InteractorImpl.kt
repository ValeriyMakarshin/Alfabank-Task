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
import io.reactivex.disposables.Disposable
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
        runTransaction { alfaDatabase.feedItemDao().updateFeedItem(list) }
    }

    override fun refresh(onSubscribe: (Disposable) -> Unit,
                         onTerminate: () -> Unit) {
        getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(onSubscribe)
            .doOnTerminate(onTerminate)
            .map {
                val (_, list) = it.channelApi?.let { it1 -> ChannelMapper.transform(it1) }
                    ?: Pair(Any(), ArrayList<FeedItemEntity>())
                list
            }
            .subscribe({ saveFeed(it) })
    }

    override fun updateBookmarkFeedItem(title: String, newBookmark: Boolean) {
        runTransaction { alfaDatabase.feedItemDao().updateBookmark(title, newBookmark) }
    }

    private fun runTransaction(function: () -> Unit) {
        alfaExecutors.diskIO.execute({
            alfaDatabase.runInTransaction({
                function.invoke()
            })
        })
    }
}
