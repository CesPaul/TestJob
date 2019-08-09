package com.cespaul.testjob.mvp.models

import android.support.v7.widget.DialogTitle

class News {

    private var newsId: Int
    private var newsTitle: String
    private var newsDecription: String
    private var newsImage: String
    private var newsPublishDate: String

    constructor(newsId: Int, newsTitle: String, newsDecription: String, newsImage: String, newsPublishDate: String) {
        this.newsId = newsId
        this.newsTitle = newsTitle
        this.newsDecription = newsDecription
        this.newsImage = newsImage
        this.newsPublishDate = newsPublishDate
    }

    fun getNewsId(): Int {
        return newsId
    }

    fun getNewsTitle(): String {
        return newsTitle
    }

    fun getNewsDescription(): String {
        return newsDecription
    }

    fun getNewsImage(): String {
        return newsImage
    }

    fun getNewsPublishDate(): String {
        return newsPublishDate
    }
}