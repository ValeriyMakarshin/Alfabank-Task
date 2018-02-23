package com.hodzi.alfabanktask

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}