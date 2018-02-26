package com.hodzi.alfabanktask.di.module

import android.app.Application
import android.content.Context
import com.hodzi.alfabanktask.AlfaApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val alfaApp: AlfaApp) {
    @Provides @Singleton
    fun provideApplication(): Application = alfaApp

    @Provides @Singleton
    fun provideContext(): Context = alfaApp.applicationContext
}
