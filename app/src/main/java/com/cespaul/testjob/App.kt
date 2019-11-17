package com.cespaul.testjob

import android.app.Application
import androidx.room.Room
import com.cespaul.testjob.data.database.NewsDatabase

/**
 * Класс для создания и инициализации базы данных.
 *
 */
class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    private lateinit var database: NewsDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(
            applicationContext,
            NewsDatabase::class.java,
            "news.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    /**
     * Получение базы данных.
     *
     * @return Готовая база данных.
     */
    fun getDatabase(): NewsDatabase {
        return database
    }
}