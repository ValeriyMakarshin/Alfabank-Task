package com.hodzi.alfabanktask.di.module

import android.app.Application
import com.evernote.android.job.JobConfig
import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.data.network.Api
import com.hodzi.alfabanktask.di.scope.FeedScope
import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.interactor.impl.InteractorImpl
import com.hodzi.alfabanktask.job.MainJobCreator
import com.hodzi.alfabanktask.main.MainContract
import com.hodzi.alfabanktask.main.MainPresenter
import com.hodzi.alfabanktask.splash.SplashContract
import com.hodzi.alfabanktask.splash.SplashPresenter
import com.hodzi.alfabanktask.utils.AlfaDatabase
import com.hodzi.alfabanktask.utils.AlfaExecutors
import dagger.Module
import dagger.Provides

@Module(includes = [JobsModule::class])
class FeedModule {
    @Provides @FeedScope
    fun provideSplashPresenter(interactor: Interactor, jobManager: JobManager):
            SplashContract.Presenter = SplashPresenter(interactor, jobManager)

    @Provides @FeedScope
    fun provideMainPresenter(interactor: Interactor): MainContract.Presenter =
            MainPresenter(interactor)


    @Provides @FeedScope
    fun provideInteractor(alfaExecutors: AlfaExecutors,
                          alfaDatabase: AlfaDatabase,
                          api: Api): Interactor {
        return InteractorImpl(alfaExecutors, alfaDatabase, api)
    }

    @Provides @FeedScope
    fun provideJobManager(application: Application, mainJobCreator: MainJobCreator): JobManager {
        JobManager.create(application).addJobCreator(mainJobCreator)
        JobConfig.setAllowSmallerIntervalsForMarshmallow(true)
        return JobManager.instance()
    }
}
