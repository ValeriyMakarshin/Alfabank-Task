package com.hodzi.alfabanktask.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.VisibleForTesting

abstract class BasePresenter<V : BaseView> {
    var view: V? = null
    private var bundle: Bundle? = null

    @CallSuper
    open fun attach(view: V, bundle: Bundle? = null) {
        this.view = view
        bundle?.let { parseArguments(it) }

        loadData()
    }

    @CallSuper
    @VisibleForTesting
    open fun parseArguments(extras: Bundle) {
        this.bundle = extras
    }

    @VisibleForTesting
    open fun loadData() {

    }

    @CallSuper
    @VisibleForTesting
    fun detach() {
        unsubscribeSubscription()
    }

    @VisibleForTesting
    open fun unsubscribeSubscription() {

    }
}