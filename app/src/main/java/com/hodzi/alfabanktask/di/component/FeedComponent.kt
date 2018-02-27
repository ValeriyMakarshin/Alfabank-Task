package com.hodzi.alfabanktask.di.component

import com.hodzi.alfabanktask.di.module.FeedModule
import com.hodzi.alfabanktask.di.scope.FeedScope
import com.hodzi.alfabanktask.main.MainActivity
import com.hodzi.alfabanktask.splash.SplashActivity
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule


@Subcomponent(modules = [AndroidInjectionModule::class, FeedModule::class])
@FeedScope
interface FeedComponent {
    fun inject(splashActivity: SplashActivity)

    fun inject(mainActivity: MainActivity)
}
