package com.hodzi.alfabanktask.data

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "channel", strict = false)
class Channel(
    @field:ElementList(inline = true, name = "item")
    var feedItems: List<FeedItem>? = null
)