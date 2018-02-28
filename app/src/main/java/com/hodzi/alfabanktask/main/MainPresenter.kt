package com.hodzi.alfabanktask.main

import android.util.Log
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
                Log.e("123", "123")
            }
    }
}
