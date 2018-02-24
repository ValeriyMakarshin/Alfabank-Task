package com.hodzi.alfabanktask.di


import com.hodzi.alfabanktask.AlfaApp

object AppInjector {

    fun init(alfaApp: AlfaApp) {
        DaggerAppComponent
            .builder()
            .application(alfaApp)
            .build()
            .inject(alfaApp)
    }

}
