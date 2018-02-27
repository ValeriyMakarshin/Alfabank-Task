package com.hodzi.alfabanktask.splash

import com.hodzi.alfabanktask.utils.base.BaseContract


interface SplashContract {
    interface Navigator {
        fun mainScreen()
    }

    interface View : BaseContract.View, Navigator

    interface Presenter : BaseContract.Presenter<View>
}
