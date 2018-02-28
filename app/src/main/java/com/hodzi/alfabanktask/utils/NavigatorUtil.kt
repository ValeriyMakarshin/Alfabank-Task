package com.hodzi.alfabanktask.utils

import android.content.Context
import android.content.Intent
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.feed.FeedActivity
import com.hodzi.alfabanktask.feed.detail.DetailFeedActivity

object NavigatorUtil {
    fun mainScreen(context: Context) {
        context.startActivity(clearStack(Intent(context, FeedActivity::class.java)))
    }

    fun detailFeed(context: Context, position: Int,
                   feedItemEntities: List<FeedItemEntity>) {
        context.startActivity(DetailFeedActivity.intent(context, position, feedItemEntities))
    }


    private fun clearStack(intent: Intent): Intent {
        return intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }


}
