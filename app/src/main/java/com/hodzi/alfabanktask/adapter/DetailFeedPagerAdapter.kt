package com.hodzi.alfabanktask.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.feed.detail.content.ContentFeedFragment

class DetailFeedPagerAdapter(fragmentManager: FragmentManager,
                             private val feedItemEntities: Array<FeedItemEntity>) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment =
        ContentFeedFragment.newInstance(feedItemEntities[position])

    override fun getCount(): Int = feedItemEntities.size

}
