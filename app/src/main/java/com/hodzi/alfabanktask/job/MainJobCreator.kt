package com.hodzi.alfabanktask.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import com.hodzi.alfabanktask.di.scope.FeedScope
import javax.inject.Inject
import javax.inject.Provider

@FeedScope
class MainJobCreator @Inject constructor(
        private val jobs: @JvmSuppressWildcards Map<String, Provider<Job>>) : JobCreator {

    override fun create(tag: String): Job? {
        val jobProvider = jobs[tag]
        return jobProvider?.get()
    }
}
