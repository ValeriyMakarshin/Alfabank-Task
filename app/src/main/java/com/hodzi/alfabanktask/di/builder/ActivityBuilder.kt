package com.hodzi.alfabanktask.di.builder

import com.hodzi.alfabanktask.main.MainActivity
import com.hodzi.alfabanktask.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity
}
