package com.hodzi.alfabanktask.feed.detail.content

import com.hodzi.alfabanktask.utils.base.BaseContract

interface ContentFeedContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}