package com.hodzi.alfabanktask.data.local.dao

import android.arch.persistence.room.*
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import io.reactivex.Flowable


@Dao
abstract class FeedItemDao {
    @Query("SELECT * FROM feed_items ORDER BY bookmark")
    abstract fun loadAllFeedItems(): Flowable<List<FeedItemEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertAll(feedItemEntities: List<FeedItemEntity>)

    @Query("DELETE FROM feed_items WHERE bookmark = 0")
    abstract fun deleteWithoutBookmark()

    @Query("DELETE FROM feed_items")
    abstract fun deleteAll()

    @Transaction
    open fun updateFeedItem(feedItemEntities: List<FeedItemEntity>) {
        deleteWithoutBookmark()
        insertAll(feedItemEntities)
    }

    @Query("UPDATE feed_items SET bookmark = :newBookmark WHERE title = :title")
    abstract fun updateBookmark(title: String, newBookmark: Boolean)
}
