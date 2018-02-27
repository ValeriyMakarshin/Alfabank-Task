package com.hodzi.alfabanktask.data.mapper

import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.network.model.FeedItemApi

class FeedItemMapper {
    fun transform(feedItemApi: FeedItemApi, channelId: Int = -1): FeedItemEntity {
        val feedItemEntity = FeedItemEntity()
        feedItemEntity.ownerId = channelId
        feedItemEntity.title = feedItemApi.title
        feedItemEntity.link = feedItemApi.link
        feedItemEntity.description = feedItemApi.description
        feedItemEntity.guid = feedItemApi.guid
        return feedItemEntity
    }

    fun t2ransform(listFeedItemApi: List<FeedItemApi>, channelId: Int = -1): List<FeedItemEntity> {
    }
}