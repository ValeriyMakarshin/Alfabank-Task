package com.hodzi.alfabanktask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hodzi.alfabanktask.data.network.Api
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var api: Api

    @Inject lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        setSupportActionBar(toolbar)

    }

}
