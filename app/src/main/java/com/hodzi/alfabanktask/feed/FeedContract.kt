package com.hodzi.alfabanktask.feed

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseContract

interface FeedContract {
    interface View : BaseContract.View {
        fun showList(feedItemEntities: List<FeedItemEntity>)
    }

    interface Presenter : BaseContract.Presenter<View>
}
