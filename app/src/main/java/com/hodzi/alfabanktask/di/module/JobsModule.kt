package com.hodzi.alfabanktask.di.module

import android.app.Application
import com.evernote.android.job.Job
import com.evernote.android.job.JobConfig
import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.FeedJob
import com.hodzi.alfabanktask.Interactor
import com.hodzi.alfabanktask.MainJobCreator
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import javax.inject.Singleton

@Module
class JobsModule {

    @Provides @IntoMap
    @StringKey(FeedJob.TAG)
    fun provideShowNotificationJob(interactor: Interactor): Job = FeedJob(interactor)

}