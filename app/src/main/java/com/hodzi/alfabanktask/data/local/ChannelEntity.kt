package com.hodzi.alfabanktask.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "channels")
data class ChannelEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "entryId")
    var entryId: Int = 0,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "link")
    var link: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "language")
    var language: String? = null,
    @ColumnInfo(name = "docs")
    var docs: String? = null,
    @ColumnInfo(name = "managingEditor")
    var managingEditor: String? = null,
    @ColumnInfo(name = "webMaster")
    var webMaster: String? = null
)
