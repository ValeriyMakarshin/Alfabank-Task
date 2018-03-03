package com.hodzi.alfabanktask.feed.detail

import android.os.Bundle
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.utils.base.BasePresenter

class DetailFeedPresenter(val interactor: Interactor) :
    BasePresenter<DetailFeedContract.View>(), DetailFeedContract.Presenter {
    override lateinit var array: Array<FeedItemEntity>

    var position: Int = 0

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

    override fun usedBookmark(position: Int): Boolean = array[position].bookmark

    override fun switchUsedBookmark(position: Int): Boolean {
        val bookmark = !usedBookmark(position)
        interactor.updateBookmarkFeedItem(array[position].title, bookmark)
        array[position].bookmark = bookmark
        return bookmark
    }

}
