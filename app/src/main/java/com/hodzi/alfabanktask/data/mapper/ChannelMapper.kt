package com.hodzi.alfabanktask.data.mapper

import com.hodzi.alfabanktask.data.local.ChannelEntity
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.network.model.ChannelApi

class ChannelMapper {
    companion object {
        fun transform(channelApi: ChannelApi): Pair<ChannelEntity, List<FeedItemEntity>> {
            val channelEntity = ChannelEntity()
            channelEntity.title = channelApi.title
            channelEntity.link = channelApi.link
            channelEntity.description = channelApi.description
            channelEntity.language = channelApi.language
            channelEntity.docs = channelApi.docs
            channelEntity.managingEditor = channelApi.managingEditor
            channelEntity.webMaster = channelApi.webMaster

            val listFeedItemEntity = channelApi.feedItemApis?.let {
                FeedItemMapper.transformList(it, -1)
            } ?: ArrayList()
            return Pair(channelEntity, listFeedItemEntity)
        }
    }
}
