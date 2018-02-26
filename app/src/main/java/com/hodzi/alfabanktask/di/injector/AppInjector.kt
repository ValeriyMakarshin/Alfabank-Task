package com.hodzi.alfabanktask.di.injector

import com.hodzi.alfabanktask.AlfaApp
import com.hodzi.alfabanktask.di.component.DaggerAppComponent
import com.hodzi.alfabanktask.di.module.AppModule

object AppInjector {

    fun init(alfaApp: AlfaApp) {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(alfaApp))
                .build()
                .inject(alfaApp)
    }

}
