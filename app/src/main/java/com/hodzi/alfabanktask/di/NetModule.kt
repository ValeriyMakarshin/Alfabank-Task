package com.hodzi.alfabanktask.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.hodzi.alfabanktask.util.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton


@Module
class NetModule {
    val baseUrl = "https://alfabank.ru"

    @Provides @Singleton fun provideApi(okHttpClient: OkHttpClient): Api =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(Api::class.java)

    @Provides @Singleton fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

}