package com.hodzi.alfabanktask.feed.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity


class DetailFeedActivity : BaseActivity<DetailFeedContract.View, DetailFeedContract.Presenter>(),
    DetailFeedContract.View {
    companion object {
        private const val EXTRA_POSITION = "extraPosition"
        private const val EXTRA_FEED_ITEM_LIST = "extraFeedItemList"

        fun intent(context: Context, position: Int,
                   feedItemEntities: List<FeedItemEntity>): Intent {
            val bundle = Bundle()
            bundle.putInt(EXTRA_POSITION, position)
            bundle.putParcelableArray(EXTRA_FEED_ITEM_LIST, feedItemEntities.toTypedArray())
            return Intent(context, DetailFeedActivity::class.java).putExtras(bundle)
        }
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_detail_feed)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }
}
