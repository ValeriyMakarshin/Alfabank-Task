package com.hodzi.alfabanktask.data.network.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class FeedApi(
    @field:Element(name = "channelApi")
    var channelApi: ChannelApi? = null
)