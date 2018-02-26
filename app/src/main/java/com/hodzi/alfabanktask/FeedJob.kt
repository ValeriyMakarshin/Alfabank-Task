package com.hodzi.alfabanktask

import android.util.Log
import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import javax.inject.Inject


class FeedJob @Inject constructor(val interactor: Interactor) : Job() {

    companion object {
        const val TAG = "feedJobTag"

        fun scheduleJob() {
            JobRequest.Builder(TAG)
                .setPeriodic(60_000L)
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