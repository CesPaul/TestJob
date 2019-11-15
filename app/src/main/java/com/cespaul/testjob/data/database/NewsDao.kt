package com.cespaul.testjob.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cespaul.testjob.model.Article

@Dao
interface NewsDao {

    @Insert
    fun insertArticle(data: List<Article>)

    @Query("select * from article order by publishedAt desc")
    fun selectArticles(): List<Article>

    @Query("delete from article")
    fun clearNews()

    /*@Query("delete from article where publishedAt = :publishedAt")
    fun deleteArticle(publishedAt: Long)*/
}