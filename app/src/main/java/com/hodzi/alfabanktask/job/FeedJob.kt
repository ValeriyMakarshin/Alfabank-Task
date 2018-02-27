package com.hodzi.alfabanktask.job

import android.util.Log
import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.hodzi.alfabanktask.interactor.Interactor
import javax.inject.Inject


class FeedJob @Inject constructor(val interactor: Interactor) : Job() {

    companion object {
        const val TAG = "feedJobTag"
        const val PERIODIC_TIME_MS = 60_000L

        fun scheduleJob() {
            JobRequest.Builder(TAG)
                .setPeriodic(PERIODIC_TIME_MS)
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .setUpdateCurrent(true)
                .build()
                .schedule()
        }
    }

    override fun onRunJob(params: Params): Result {
        Log.d("132", "132")
        return Result.SUCCESS
    }

}
