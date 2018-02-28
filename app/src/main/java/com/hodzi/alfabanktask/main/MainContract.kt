package com.hodzi.alfabanktask.main

import com.hodzi.alfabanktask.utils.base.BaseContract

interface MainContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View> {
//        fun getList()
    }
}
