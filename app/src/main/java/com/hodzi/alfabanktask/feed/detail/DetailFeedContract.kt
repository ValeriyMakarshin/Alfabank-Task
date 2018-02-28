package com.hodzi.alfabanktask.feed.detail

import com.hodzi.alfabanktask.utils.base.BaseContract

interface DetailFeedContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}