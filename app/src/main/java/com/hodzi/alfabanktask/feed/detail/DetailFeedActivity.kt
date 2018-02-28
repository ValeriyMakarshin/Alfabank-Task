package com.hodzi.alfabanktask.feed.detail

import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity

class DetailFeedActivity : BaseActivity<DetailFeedContract.View, DetailFeedContract.Presenter>(),
    DetailFeedContract.View {
    override fun getActivityInfo(): ActivityInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injection(): () -> Unit = { AppInjector.inject(this) }
}
