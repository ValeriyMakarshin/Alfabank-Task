package com.hodzi.alfabanktask.data.mapper

import com.hodzi.alfabanktask.data.local.ChannelEntity
import com.hodzi.alfabanktask.data.network.model.ChannelApi

class ChannelMapper {
    fun transform(channelApi: ChannelApi): ChannelEntity {
        val channelEntity = ChannelEntity()
        channelEntity.title = channelApi.title
        channelEntity.link = channelApi.link
        channelEntity.description = channelApi.description
        channelEntity.language = channelApi.language
        channelEntity.docs = channelApi.docs
        channelEntity.managingEditor = channelApi.managingEditor
        channelEntity.webMaster = channelApi.webMaster
        return channelEntity
    }
}