package com.hodzi.alfabanktask

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator

class MainJobCreator : JobCreator {
    override fun create(tag: String): Job? =
            when (tag) {
                FeedJob.TAG -> FeedJob()
                else -> null
            }
}