package com.hodzi.alfabanktask.feed.detail

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseContract

interface DetailFeedContract {
    interface View : BaseContract.View {
        fun showList(feedItemEntities: Array<FeedItemEntity>)

        fun focusPosition(position: Int)
    }

    interface Presenter : BaseContract.Presenter<View>
}
