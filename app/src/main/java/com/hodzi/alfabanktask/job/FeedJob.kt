package com.hodzi.alfabanktask.job

import android.util.Log
import com.evernote.android.job.Job
import com.evernote.android.job.JobManager
import com.evernote.android.job.JobRequest
import com.hodzi.alfabanktask.interactor.Interactor
import javax.inject.Inject


class FeedJob @Inject constructor(val interactor: Interactor) : Job() {

    companion object {
        const val TAG = "feedJobTag"
        private const val PERIODIC_TIME_MS = 300_000L

        fun startScheduleJob() {
            if (JobManager.instance().allJobRequests.size == 0) {
                JobRequest.Builder(TAG)
                    .setPeriodic(PERIODIC_TIME_MS)
                    .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                    .setUpdateCurrent(true)
                    .build()
                    .schedule()
            }
        }
    }

    override fun onRunJob(params: Params): Result {
        Log.i("132", "onRunJob")
        interactor.refresh()

        return Result.SUCCESS
    }

}
