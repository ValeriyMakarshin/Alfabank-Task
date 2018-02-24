package com.hodzi.alfabanktask.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "channels")
class ChannelEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "entryId")
    var entryId: Int,
    var title: String? = null,
    var link: String? = null,
    var description: String? = null,
    var language: String? = null,
    var docs: String? = null,
    var managingEditor: String? = null,
    var webMaster: String? = null
)