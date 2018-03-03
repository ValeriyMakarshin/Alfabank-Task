package com.hodzi.alfabanktask.data.mapper

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.network.model.FeedItemApi

class FeedItemMapper {
    companion object {

        fun transform(feedItemApi: FeedItemApi, channelId: Int = -1): FeedItemEntity {
            val feedItemEntity = FeedItemEntity()
            feedItemEntity.ownerId = channelId
            feedItemApi.title?.let { feedItemEntity.title = it }
            feedItemEntity.link = feedItemApi.link
            feedItemEntity.description = feedItemApi.description
            feedItemEntity.guid = feedItemApi.guid
            return feedItemEntity
        }

        fun transformList(listFeedItemApi: List<FeedItemApi>, channelId: Int = -1):
            List<FeedItemEntity> {
            val list = ArrayList<FeedItemEntity>()
            listFeedItemApi.forEach { list.add(transform(it, channelId)) }
            return list
        }
    }
}
