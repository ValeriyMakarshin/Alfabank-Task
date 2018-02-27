package com.hodzi.alfabanktask.splash

import android.os.Bundle
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity

class SplashActivity : BaseActivity<SplashContract.View, SplashContract.Presenter>(),
        SplashContract.View {

    override fun injection() = { AppInjector.inject(this) }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.splash_activity)

}
