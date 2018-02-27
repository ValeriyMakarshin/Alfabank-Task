package com.hodzi.alfabanktask.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hodzi.alfabanktask.R
import com.hodzi.alfabanktask.data.network.Api
import com.hodzi.alfabanktask.di.injector.AppInjector
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
//        AppInjector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setSupportActionBar(toolbar)

    }

}
