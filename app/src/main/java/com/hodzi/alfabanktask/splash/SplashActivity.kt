package com.hodzi.alfabanktask.splash

import android.os.Bundle
import com.hodzi.alfabanktask.FeedJob
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import dagger.android.AndroidInjection

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.splash_activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        AppInjector.inject(this)
        super.onCreate(savedInstanceState)




        FeedJob.scheduleJob()
    }
}
