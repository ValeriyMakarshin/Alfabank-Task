package com.hodzi.alfabanktask.splash

import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.Interactor
import com.hodzi.alfabanktask.utils.base.BasePresenter

class SplashPresenter constructor(val interactor: Interactor,
                                  val jobManager: JobManager
) : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

}
