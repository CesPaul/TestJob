package com.cespaul.testjob.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cespaul.testjob.model.Article

@Database(entities = [Article::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}