package com.hodzi.alfabanktask.splash

import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import javax.inject.Singleton

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.splash_activity)

}
