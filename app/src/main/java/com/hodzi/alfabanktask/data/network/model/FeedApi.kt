package com.hodzi.alfabanktask.data.network.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class FeedApi(
    @field:Element(name = "channel")
    var channelApi: ChannelApi? = null
)
