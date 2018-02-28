package com.hodzi.alfabanktask.feed

import android.support.v7.widget.LinearLayoutManager
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.adapter.FeedAdapter
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class FeedActivity : BaseActivity<FeedContract.View, FeedContract.Presenter>(), FeedContract.View {
    override fun showList(feedItemEntities: List<FeedItemEntity>) {
        uiFeedItemsRv.adapter = FeedAdapter(feedItemEntities)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_main, toolbar)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }

    override fun viewInit() {
        uiFeedItemsRv.layoutManager = LinearLayoutManager(this)
    }
}
