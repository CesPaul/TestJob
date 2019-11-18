package com.cespaul.testjob.di.module

import android.content.Context
import androidx.room.Room
import com.cespaul.testjob.data.database.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Модуль для базы данных.
 */
@Module
object DatabaseModule {

    /**
     * Создание базы данных и предоставление к ней доступа.
     *
     * @param context Контекст.
     * @return Собранная база данных.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDatabase(context: Context): NewsDatabase =
        Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "news.db"
        )
            .allowMainThreadQueries()
            .build()
}