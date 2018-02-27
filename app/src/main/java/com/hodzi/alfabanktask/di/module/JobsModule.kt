package com.hodzi.alfabanktask.di.module

import com.evernote.android.job.Job
import com.hodzi.alfabanktask.interactor.Interactor
import com.hodzi.alfabanktask.job.FeedJob
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class JobsModule {

    @Provides @IntoMap
    @StringKey(FeedJob.TAG)
    fun provideShowNotificationJob(interactor: Interactor): Job = FeedJob(interactor)

}
