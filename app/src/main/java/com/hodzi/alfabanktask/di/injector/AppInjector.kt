package com.hodzi.alfabanktask.di.injector

import com.hodzi.alfabanktask.AlfaApp
import com.hodzi.alfabanktask.di.component.AppComponent
import com.hodzi.alfabanktask.di.component.DaggerAppComponent
import com.hodzi.alfabanktask.di.component.FeedComponent
import com.hodzi.alfabanktask.di.module.AppModule
import com.hodzi.alfabanktask.di.module.FeedModule
import com.hodzi.alfabanktask.main.MainActivity
import com.hodzi.alfabanktask.splash.SplashActivity

object AppInjector {
    lateinit var feedComponent: FeedComponent

    fun inject(splashActivity: SplashActivity) {
        feedComponent.inject(splashActivity)
    }

    fun inject(mainActivity: MainActivity) {
        feedComponent.inject(mainActivity)
    }

    fun init(alfaApp: AlfaApp) {
        val appComponent: AppComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(alfaApp))
                .build()

        appComponent.inject(alfaApp)

        feedComponent = appComponent.plusFeedComponent(FeedModule())
    }

}
