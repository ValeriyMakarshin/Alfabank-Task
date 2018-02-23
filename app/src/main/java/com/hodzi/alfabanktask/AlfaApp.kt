package com.hodzi.alfabanktask

import android.app.Activity
import android.app.Application
import com.hodzi.alfabanktask.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class AlfaApp : Application(), HasActivityInjector {
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    @Inject override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}
