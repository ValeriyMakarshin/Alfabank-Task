package com.hodzi.alfabanktask.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper

open class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {
    var view: V? = null
    var bundle: Bundle? = null

    @CallSuper override fun attach(view: V, bundle: Bundle?) {
        this.view = view
        bundle?.let { parseArguments(it) }

        loadData()
    }

    @CallSuper
    override fun parseArguments(extras: Bundle) {
        this.bundle = extras
    }

    override fun loadData() {

    }

    @CallSuper
    override fun detach() {
        unsubscribeSubscription()
    }

    override fun unsubscribeSubscription() {

    }
}
