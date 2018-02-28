package com.hodzi.alfabanktask.feed.detail.content

import android.os.Bundle
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseFragment


class ContentFeedFragment :
    BaseFragment<ContentFeedContract.View, ContentFeedContract.Presenter>(),
    ContentFeedContract.View {
    companion object {
        private const val EXTRA_FEED_ITEM = "extraFeedItem"

        fun newInstance(feedItemEntity: FeedItemEntity): ContentFeedFragment {
            val fragment = ContentFeedFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_FEED_ITEM, feedItemEntity)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_content_feed)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }

}