package com.hodzi.alfabanktask.main

import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_main, toolbar)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }

}
