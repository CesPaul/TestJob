package com.cespaul.testjob.mvp.models

import com.google.gson.annotations.SerializedName

data class NewsDTO (@SerializedName("id") var newsId: Int,
                    var newsTitle: String, var newsDecription: String,
                    var newsImage: String, var newsPublishDate: String) {

    override fun toString(): String {
        return "$newsId $newsTitle $newsDecription $newsImage $newsPublishDate"
    }
}