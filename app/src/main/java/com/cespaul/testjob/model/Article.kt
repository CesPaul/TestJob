package com.cespaul.testjob.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

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