package com.hodzi.alfabanktask

import android.app.Activity
import android.app.Application
import com.evernote.android.job.JobConfig
import com.evernote.android.job.JobManager
import com.facebook.stetho.Stetho
import com.hodzi.alfabanktask.di.injector.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class AlfaApp : Application(), HasActivityInjector {
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .build())


        JobManager.create(this).addJobCreator(MainJobCreator())

        JobConfig.setAllowSmallerIntervalsForMarshmallow(true)
    }

    @Inject
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}
