package com.hodzi.alfabanktask.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors


data class AlfaExecutors(val diskIO: Executor = Executors.newSingleThreadExecutor(),
                         val mNetworkIO: Executor =
                         Executors.newFixedThreadPool(NETWORK_THREAD_POOL_SIZE),
                         val mMainThread: Executor = MainThreadExecutor()) {
    companion object {
        const val NETWORK_THREAD_POOL_SIZE = 3
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}
