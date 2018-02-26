package com.hodzi.alfabanktask.di

import android.app.Application
import com.hodzi.alfabanktask.AlfaApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    InteractorModule::class,
    NetModule::class
])
interface AppComponent {
    fun inject(alfaApp: AlfaApp)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
