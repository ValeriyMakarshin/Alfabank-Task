package com.hodzi.alfabanktask.adapter

import com.hodzi.alfabanktask.adapter.holder.MainHolder
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.utils.base.BaseRAdapter

class MainAdapter(list: List<FeedItemEntity>) :
    BaseRAdapter<FeedItemEntity, MainHolder>(list, MainHolder.creator())