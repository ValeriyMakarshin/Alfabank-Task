package com.hodzi.alfabanktask.main

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseContract

interface MainContract {
    interface View : BaseContract.View {
        fun showList(feedItemEntities: List<FeedItemEntity>)
    }

    interface Presenter : BaseContract.Presenter<View>
}
