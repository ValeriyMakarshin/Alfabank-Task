package com.hodzi.alfabanktask.main

import android.util.Log
import com.hodzi.alfabanktask.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(val interactor: Interactor) {
    fun getList() {
        interactor.getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.e("123", "123")
                }
    }
}
