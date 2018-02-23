package com.hodzi.alfabanktask.di

import com.hodzi.alfabanktask.AlfaApp
import dagger.Module

@Module
class AppModule(private val alfaApp: AlfaApp) {
//    @Provides @Singleton fun provideApplication(): Context = alfaApp
}