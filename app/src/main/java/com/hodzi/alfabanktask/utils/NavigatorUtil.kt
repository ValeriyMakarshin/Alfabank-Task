package com.hodzi.alfabanktask.utils

import android.content.Context
import android.content.Intent
import com.hodzi.alfabanktask.main.MainActivity

object NavigatorUtil {
    fun mainScreen(context: Context) {
        context.startActivity(clearStack(Intent(context, MainActivity::class.java)))
    }

    private fun clearStack(intent: Intent): Intent {
        return intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
}
