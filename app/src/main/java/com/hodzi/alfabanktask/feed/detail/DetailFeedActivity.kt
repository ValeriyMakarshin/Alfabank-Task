package com.hodzi.alfabanktask.feed.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.adapter.DetailFeedPagerAdapter
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_feed.*


class DetailFeedActivity : BaseActivity<DetailFeedContract.View, DetailFeedContract.Presenter>(),
    DetailFeedContract.View {

    override fun focusPosition(position: Int) {
        uiFeedItemsVp.currentItem = position
    }

    override fun showList(feedItemEntities: Array<FeedItemEntity>) {
        uiFeedItemsVp.adapter = DetailFeedPagerAdapter(supportFragmentManager, feedItemEntities)
    }

    companion object {
        const val EXTRA_POSITION = "extraPosition"
        const val EXTRA_FEED_ITEM_LIST = "extraFeedItemList"

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
