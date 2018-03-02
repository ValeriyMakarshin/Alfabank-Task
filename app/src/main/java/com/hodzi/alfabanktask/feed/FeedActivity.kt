package com.hodzi.alfabanktask.feed

import android.support.v7.widget.LinearLayoutManager
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.adapter.FeedAdapter
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.NavigatorUtil
import com.hodzi.alfabanktask.utils.OnClickListener
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

class FeedActivity : BaseActivity<FeedContract.View, FeedContract.Presenter>(), FeedContract.View,
    OnClickListener<FeedItemEntity> {

    override fun showList(feedItemEntities: List<FeedItemEntity>) {
        uiFeedItemsRv.adapter = FeedAdapter(feedItemEntities, this)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_main, toolbar)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }

    override fun viewInit() {
        uiFeedItemsRv.layoutManager = LinearLayoutManager(this)
        uiFeedItemsSrl.setOnRefreshListener { presenter.refresh() }
    }

    override fun detailScreen(position: Int, feedItemEntities: List<FeedItemEntity>) {
        NavigatorUtil.detailFeed(this, position, feedItemEntities)
    }

    override fun onClick(position: Int, item: FeedItemEntity) {
        detailScreen(position, presenter.list)
    }

    override fun needShowHomeButton(): Boolean = false

    override fun showRefresh() {
        uiFeedItemsSrl.isRefreshing = true
    }

    override fun hideRefresh() {
        uiFeedItemsSrl.isRefreshing = false
    }

}
