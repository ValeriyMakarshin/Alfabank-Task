package com.hodzi.alfabanktask.di.component

import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.AlfaApp
import com.hodzi.alfabanktask.di.module.AppModule
import com.hodzi.alfabanktask.di.module.DatabaseModule
import com.hodzi.alfabanktask.di.module.FeedModule
import com.hodzi.alfabanktask.di.module.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class
])
interface AppComponent {
    fun plusFeedComponent(feedModule: FeedModule): FeedComponent

    fun inject(alfaApp: AlfaApp)

    fun inject(jobManager: JobManager)
}
