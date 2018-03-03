package com.hodzi.alfabanktask.feed.detail

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseContract

interface DetailFeedContract {
    interface View : BaseContract.View {
        fun showList(feedItemEntities: Array<FeedItemEntity>)

        fun focusPosition(position: Int)
    }

    interface Presenter : BaseContract.Presenter<View> {
        val array: Array<FeedItemEntity>
            get() = ArrayList<FeedItemEntity>().toTypedArray()

        fun usedBookmark(position: Int): Boolean

        /**
         * This method is called when user want removed or added item in bookmarks.
         *
         * @return boolean Return false if item was removed from bookmarks, true - added
         */
        fun switchUsedBookmark(position: Int): Boolean
    }
}
