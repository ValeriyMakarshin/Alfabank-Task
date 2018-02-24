package com.hodzi.alfabanktask.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class AlfaExecutors(val diskIO: Executor = Executors.newSingleThreadExecutor(),
                    val mNetworkIO: Executor = Executors.newFixedThreadPool(3),
                    val mMainThread: Executor = MainThreadExecutor()) {

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}