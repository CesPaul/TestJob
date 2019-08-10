package com.cespaul.testjob.mvp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


    data class DataModel(


        @SerializedName("title")
        var title: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("url")
        var url: String, val publishDate: String,
        @SerializedName("urlToImage")
        var urlToImage: String,
        @SerializedName("publishedAt")
        var publishedAt: String)

