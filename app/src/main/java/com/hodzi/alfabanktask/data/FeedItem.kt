package com.hodzi.alfabanktask.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
class FeedItem(
    @field:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "link")
    var link: String? = null,
    @field:Element(name = "description")
    var description: String? = null,
    @field:Element(name = "guid")
    var guid: String? = null
)