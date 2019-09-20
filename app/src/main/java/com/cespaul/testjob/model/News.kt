package com.cespaul.testjob.model

import com.google.gson.annotations.SerializedName

data class News(
        val title: String,
        val description: String,
        val url: String,
        val publishDate: String,
        val urlToImage: String,
        val publishedAt: String
    )

