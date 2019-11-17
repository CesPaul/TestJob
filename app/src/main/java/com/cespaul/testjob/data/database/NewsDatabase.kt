package com.cespaul.testjob.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cespaul.testjob.model.Article

/**
 * База данных для хранения кэшированных новостей.
 *
 */
@Database(entities = [Article::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * @return Возвращает DAO.
     */
    abstract fun newsDao(): NewsDao
}