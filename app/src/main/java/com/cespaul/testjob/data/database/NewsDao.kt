package com.cespaul.testjob.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cespaul.testjob.model.Article

/**
 * Управление базой данных новостей.
 *
 */
@Dao
interface NewsDao {

    /**
     * Вставка списка новостей в таблицу базы данных.
     *
     * @param data Это список новостей.
     */
    @Insert
    fun insertArticle(data: List<Article>)

    /**
     * Получение списка новостей из таблицы базы данных.
     *
     * @return Возвращает список новостей.
     */
    @Query("select * from article order by publishedAt desc")
    fun selectArticles(): List<Article>

    /**
     * Очистка таблицы новостей в базе данных.
     *
     */
    @Query("delete from article")
    fun clearNews()
}