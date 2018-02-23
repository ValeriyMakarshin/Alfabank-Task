package com.hodzi.alfabanktask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hodzi.alfabanktask.util.Api
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        setSupportActionBar(toolbar)

        Log.e("132", "123")
    }

}
