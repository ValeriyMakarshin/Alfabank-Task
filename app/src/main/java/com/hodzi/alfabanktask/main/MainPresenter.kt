package com.hodzi.alfabanktask.main

import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.utils.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(val interactor: Interactor) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {
    override fun loadData() {
        interactor.getDbList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view?.showList(it)
            }
    }
}
