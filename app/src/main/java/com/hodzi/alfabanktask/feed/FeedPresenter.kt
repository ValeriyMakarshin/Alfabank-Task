package com.hodzi.alfabanktask.feed

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.utils.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FeedPresenter(val interactor: Interactor) : BasePresenter<FeedContract.View>(),
    FeedContract.Presenter {

    override lateinit var list: List<FeedItemEntity>

    override fun loadData() {
        interactor.getDbList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                list = it
                view?.showList(it)
            }
    }

    override fun refresh() {
        interactor.refresh({ view?.showRefresh() }, { view?.hideRefresh() })
    }
}
