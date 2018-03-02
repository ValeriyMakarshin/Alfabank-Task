package com.hodzi.alfabanktask.utils.base

import android.os.Bundle

interface BaseContract {
    interface View {
        fun setTitle(title: String)
    }

    interface Presenter<in V : View> {
        fun attach(view: V, bundle: Bundle? = null)

        fun parseArguments(extras: Bundle)

        fun loadData()

        fun detach()

        fun unsubscribeSubscription()

    }
}

