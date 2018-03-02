package com.hodzi.alfabanktask.adapter

import com.hodzi.alfabanktask.adapter.holder.FeedHolder
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.OnClickListener
import com.hodzi.alfabanktask.utils.base.BaseRAdapter

class FeedAdapter(list: List<FeedItemEntity>, onClickListener: OnClickListener<FeedItemEntity>) :
    BaseRAdapter<FeedItemEntity, FeedHolder>(list, FeedHolder.creator(), onClickListener)
