package com.hodzi.alfabanktask.feed.detail

import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity

class DetailFeedActivity : BaseActivity<DetailFeedContract.View, DetailFeedContract.Presenter>(),
    DetailFeedContract.View {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_detail_feed)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }
}
