package com.hodzi.alfabanktask.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "channel", strict = false)
class Channel(
    @field:ElementList(inline = true, name = "item")
    var feedItems: List<FeedItem>? = null,
    @field:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "link")
    var link: String? = null,
    @field:Element(name = "description")
    var description: String? = null,
    @field:Element(name = "language")
    var language: String? = null,
    @field:Element(name = "docs")
    var docs: String? = null,
    @field:Element(name = "managingEditor")
    var managingEditor: String? = null,
    @field:Element(name = "webMaster")
    var webMaster: String? = null

)