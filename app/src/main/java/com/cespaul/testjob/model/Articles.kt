package com.cespaul.testjob.model

import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("articles")
    val articles : List<Article>
    )