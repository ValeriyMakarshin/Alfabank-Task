package com.hodzi.alfabanktask.feed

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseContract

interface FeedContract {
    interface Navigator {
        fun detailScreen(position: Int,
                         feedItemEntities: List<FeedItemEntity>)
    }

    interface View : BaseContract.View, Navigator {
        fun showList(feedItemEntities: List<FeedItemEntity>)

        fun showRefresh()

        fun hideRefresh()
    }

    interface Presenter : BaseContract.Presenter<View> {
        var list: List<FeedItemEntity>

        fun refresh()

    }
}
