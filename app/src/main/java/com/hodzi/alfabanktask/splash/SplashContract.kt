package com.hodzi.alfabanktask.splash

import com.hodzi.alfabanktask.utils.base.BaseContract


interface SplashContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}