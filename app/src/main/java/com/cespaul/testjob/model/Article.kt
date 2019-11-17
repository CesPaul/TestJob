package com.cespaul.testjob.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Модель новостной статьи.
 * Используется для парсинга JSOТ (как POJO модель).
 * Используется в качестве сущности дял таблицы в базе данных новостей.
 *
 * @property id Идентификационный номер.
 * @property title Заголовок новости.
 * @property description Описание новости.
 * @property url Адрес новости в Интернете.
 * @property urlToImage Адрес на картинку.
 * @property publishedAt Дата и время публикации новости.
 */
@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String?,
    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String?,
    @SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String?,
    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String
)