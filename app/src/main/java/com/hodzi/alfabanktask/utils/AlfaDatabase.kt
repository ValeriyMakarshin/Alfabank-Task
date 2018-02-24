package com.hodzi.alfabanktask.utils

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hodzi.alfabanktask.data.local.ChannelEntity
import com.hodzi.alfabanktask.data.local.FeedItemEntity
import com.hodzi.alfabanktask.data.local.dao.ChannelDao
import com.hodzi.alfabanktask.data.local.dao.FeedItemDao


@Database(entities = [ChannelEntity::class, FeedItemEntity::class], version = 1)
abstract class AlfaDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "shopping-helper-db"

        private var sInstance: AlfaDatabase? = null

        fun getInstance(context: Context, executors: AlfaExecutors): AlfaDatabase {
            if (sInstance == null) {
                synchronized(AlfaDatabase::class.java) {
                    if (sInstance == null) {
                        sInstance = createDatabase(context.applicationContext, executors)
                        sInstance?.updateDatabaseCreated(context.applicationContext)
                    }
                }
            }
            return sInstance!!
        }

        private fun createDatabase(appContext: Context,
                                   executors: AlfaExecutors): AlfaDatabase {
            return Room.databaseBuilder(appContext, AlfaDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        executors.diskIO.execute({
                            val database = AlfaDatabase.getInstance(appContext, executors)
                            database.setDatabaseCreated()
                        })
                    }
                }).build()
        }
    }



    abstract fun channelDao(): ChannelDao

    abstract fun feedItemDao(): FeedItemDao

    private fun setDatabaseCreated() {
//        mIsDatabaseCreated.postValue(true)
    }
//
    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
//            setDatabaseCreated()
        }
    }


}