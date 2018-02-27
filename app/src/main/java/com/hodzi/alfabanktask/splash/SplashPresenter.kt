package com.hodzi.alfabanktask.splash

import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.job.FeedJob
import com.hodzi.alfabanktask.utils.base.BasePresenter

class SplashPresenter constructor(val jobManager: JobManager) :
    BasePresenter<SplashContract.View>(), SplashContract.Presenter {
    override fun loadData() {
        FeedJob.startScheduleJob()
        view?.mainScreen()
    }
}
