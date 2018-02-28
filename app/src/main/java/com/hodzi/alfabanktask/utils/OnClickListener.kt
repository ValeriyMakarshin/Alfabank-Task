package com.hodzi.alfabanktask.utils

interface OnClickListener<in T> {
    fun onClick(position: Int, item: T)
}
