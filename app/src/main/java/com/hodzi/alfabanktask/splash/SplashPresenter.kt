package com.hodzi.alfabanktask.splash

import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.Interactor
import com.hodzi.alfabanktask.utils.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

class SplashPresenter constructor(val interactor: Interactor,
                                          val jobManager: JobManager
) : BasePresenter<SplashView>() {

}
