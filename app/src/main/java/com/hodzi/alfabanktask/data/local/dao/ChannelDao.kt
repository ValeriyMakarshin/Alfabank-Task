package com.hodzi.alfabanktask.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hodzi.alfabanktask.data.local.ChannelEntity
import io.reactivex.Flowable

@Dao
interface ChannelDao {
    @Query("SELECT * FROM channels")
    fun loadAllChannels(): Flowable<List<ChannelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(ChannelEntities: List<ChannelEntity>)
}