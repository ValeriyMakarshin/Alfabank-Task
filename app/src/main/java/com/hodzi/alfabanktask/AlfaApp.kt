package com.hodzi.alfabanktask

import android.app.Application
import com.facebook.stetho.Stetho
import com.hodzi.alfabanktask.di.injector.AppInjector

class AlfaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .build())

    }
}
