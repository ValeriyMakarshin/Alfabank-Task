package com.hodzi.alfabanktask.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.hodzi.alfabanktask.interactor.Interactor
import javax.inject.Inject


class FeedJob @Inject constructor(val interactor: Interactor) : Job() {

    companion object {
        const val TAG = "feedJobTag"
        //TODO: change period
        private const val PERIODIC_TIME_MS = 60_000L

        fun startScheduleJob() {
            JobRequest.Builder(TAG)
                .setPeriodic(PERIODIC_TIME_MS)
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .setUpdateCurrent(true)
                .build()
                .schedule()
        }
    }

    override fun onRunJob(params: Params): Result {
        interactor.refresh()

        return Result.SUCCESS
    }

}
