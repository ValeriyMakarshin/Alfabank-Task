package com.hodzi.alfabanktask

import com.hodzi.alfabanktask.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}
