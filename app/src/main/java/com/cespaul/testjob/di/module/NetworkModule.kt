package com.cespaul.testjob.di.module

import com.cespaul.testjob.data.network.NewsApi
import com.cespaul.testjob.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
object NetworkModule {

    /**
     * Для предоставления API.
     *
     * @param retrofit Экземпляр Retrofit.
     * @return Реализация API.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideNewsApi(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

    /**
     * Для предоставления интерфейса дял Retrofit.
     *
     * @return Retrofit.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
}