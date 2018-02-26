package com.hodzi.alfabanktask.di.component

import android.app.Application
import com.hodzi.alfabanktask.AlfaApp
import com.hodzi.alfabanktask.di.builder.ActivityBuilder
import com.hodzi.alfabanktask.di.module.AppModule
import com.hodzi.alfabanktask.di.module.DatabaseModule
import com.hodzi.alfabanktask.di.module.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    ActivityBuilder::class
])
interface AppComponent {
    fun inject(alfaApp: AlfaApp)
}
