package com.hodzi.alfabanktask.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import io.reactivex.Flowable


@Dao
interface FeedItemDao {
    @Query("SELECT * FROM feed_items")
    fun loadAllFeedItems(): Flowable<List<FeedItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(feedItemEntities: List<FeedItemEntity>)
}