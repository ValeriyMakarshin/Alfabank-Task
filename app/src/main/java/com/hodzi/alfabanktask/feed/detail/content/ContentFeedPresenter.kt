package com.hodzi.alfabanktask.feed.detail.content

import android.os.Bundle
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BasePresenter

class ContentFeedPresenter : BasePresenter<ContentFeedContract.View>(),
    ContentFeedContract.Presenter {

    lateinit var feedItemEntity: FeedItemEntity

    override fun parseArguments(extras: Bundle) {
        super.parseArguments(extras)
        feedItemEntity = extras.getParcelable(ContentFeedFragment.EXTRA_FEED_ITEM)
    }

    override fun loadData() {
        feedItemEntity.description?.let { view?.setData(it) }
    }


}

