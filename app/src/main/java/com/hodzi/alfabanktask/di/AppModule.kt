package com.hodzi.alfabanktask.di

import android.app.Application
import com.hodzi.alfabanktask.MainPresenter
import com.hodzi.alfabanktask.data.local.dao.ChannelDao
import com.hodzi.alfabanktask.data.local.dao.FeedItemDao
import com.hodzi.alfabanktask.utils.AlfaDatabase
import com.hodzi.alfabanktask.utils.AlfaExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {
    @Singleton @Provides
    fun provideMainPresenter(alfaExecutors: AlfaExecutors): MainPresenter {
        return MainPresenter(alfaExecutors)
    }

    @Singleton @Provides
    fun provideDb(app: Application, alfaExecutors: AlfaExecutors): AlfaDatabase {
        return AlfaDatabase.getInstance(app, alfaExecutors)
    }

    @Singleton @Provides
    fun provideChannelDao(alpDatabase: AlfaDatabase): ChannelDao {
        return alpDatabase.channelDao()
    }

    @Singleton @Provides
    fun provideFeedItemDao(alpDatabase: AlfaDatabase): FeedItemDao {
        return alpDatabase.feedItemDao()
    }

    @Singleton @Provides
    fun provideAppExecutors(): AlfaExecutors {
        return AlfaExecutors()
    }

}
