package com.hodzi.alfabanktask.feed.detail.content

import android.os.Bundle
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.di.injector.AppInjector
import com.hodzi.alfabanktask.utils.base.ActivityInfo
import com.hodzi.alfabanktask.utils.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_content_feed.*
import kotlinx.android.synthetic.main.view_toolbar.*


class ContentFeedFragment :
    BaseFragment<ContentFeedContract.View, ContentFeedContract.Presenter>(),
    ContentFeedContract.View {

    companion object {
        const val EXTRA_FEED_ITEM = "extraFeedItem"

        fun newInstance(feedItemEntity: FeedItemEntity): ContentFeedFragment {
            val fragment = ContentFeedFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_FEED_ITEM, feedItemEntity)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.fragment_content_feed, toolbar)

    override fun injection(): () -> Unit = { AppInjector.inject(this) }

    override fun setData(data: String) {
        uiFeedWv.loadData(data, "text/html; charset=utf-8", "UTF-8")
    }

    override fun viewInit() {
        super.viewInit()
        setHasOptionsMenu(true)
    }

}
