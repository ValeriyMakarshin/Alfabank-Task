package com.hodzi.alfabanktask.utils

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.text.Spanned


class HtmlUtil {
    companion object {
        @SuppressLint("ObsoleteSdkInt")
        fun fromHtmlFormat(string: String): Spanned? {

            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(string, Html.FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(string)
            }
        }
    }

}
