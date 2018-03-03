package com.hodzi.alfabanktask.data.local

import android.annotation.SuppressLint
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@Entity(tableName = "feed_items")
data class FeedItemEntity(
    @ColumnInfo(name = "ownerId")
    var ownerId: Int? = null,
    @PrimaryKey @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "bookmark")
    var bookmark: Boolean = false,
    @ColumnInfo(name = "link")
    var link: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "guid")
    var guid: String? = null
) : Parcelable
