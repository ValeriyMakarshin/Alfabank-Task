package com.hodzi.alfabanktask.feed.detail

import android.os.Bundle
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BasePresenter

class DetailFeedPresenter : BasePresenter<DetailFeedContract.View>(), DetailFeedContract.Presenter {
    var position: Int = 0
    lateinit var array: Array<FeedItemEntity>

    override fun parseArguments(extras: Bundle) {
        super.parseArguments(extras)
        position = extras.getInt(DetailFeedActivity.EXTRA_POSITION)
        array = extras.getParcelableArray(DetailFeedActivity.EXTRA_FEED_ITEM_LIST)
            .map { it as FeedItemEntity }
            .toTypedArray()
    }

    override fun attach(view: DetailFeedContract.View, bundle: Bundle?) {
        super.attach(view, bundle)

        view.showList(array)
        view.focusPosition(position)
    }
}
