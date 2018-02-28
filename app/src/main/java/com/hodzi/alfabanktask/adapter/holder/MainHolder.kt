package com.hodzi.alfabanktask.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseHolder
import kotlinx.android.synthetic.main.item_feed_item.view.*

class MainHolder(itemView: View) : BaseHolder<FeedItemEntity>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> MainHolder =
            { viewGroup ->
                MainHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_feed_item, viewGroup, false))
            }
    }

    override fun onDraw(item: FeedItemEntity) {
        itemView.uiFeedItemsTitleTv.text = item.title
    }
}