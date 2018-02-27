package com.hodzi.alfabanktask.di.component

import com.evernote.android.job.JobManager
import com.hodzi.alfabanktask.AlfaApp
import com.hodzi.alfabanktask.di.builder.ActivityBuilder
import com.hodzi.alfabanktask.di.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    ActivityBuilder::class
])
interface AppComponent {
    fun plusFeedComponent(feedModule: FeedModule): FeedComponent

    fun inject(alfaApp: AlfaApp)

    fun inject(jobManager: JobManager)
}
