package com.hodzi.alfabanktask.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.mapper.ChannelMapper
import com.hodzi.alfabanktask.interactor.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FeedJob @Inject constructor(val interactor: Interactor) : Job() {

    companion object {
        const val TAG = "feedJobTag"
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
        interactor.getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val (_, list) = it.channelApi?.let { it1 -> ChannelMapper.transform(it1) }
                    ?: Pair(Any(), ArrayList<FeedItemEntity>())
                list
            }
            .subscribe({ interactor.saveFeed(it) })

        return Result.SUCCESS
    }

}
