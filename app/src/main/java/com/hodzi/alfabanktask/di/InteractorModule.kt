package com.hodzi.alfabanktask.di

import com.hodzi.alfabanktask.main.MainActivity
import com.hodzi.alfabanktask.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InteractorModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity
}
