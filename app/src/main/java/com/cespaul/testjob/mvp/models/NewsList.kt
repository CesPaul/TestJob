package com.cespaul.testjob.mvp.models

class NewsList {
    private lateinit var title: String
    private lateinit var description: String
    private lateinit var imgUrl: String
    private lateinit var publishDate: String
    private lateinit var html_url: String

    fun getTitle(): String{return title}

    fun getDescription(): String{return description}

    fun getimgUrl(): String{return imgUrl}

    fun getPublishDate(): String{return publishDate}

    fun hetUrl(): String{return html_url}

    constructor(title: String, description: String, imgUrl: String, publishDate: String, newsUrl: String) {
        this.title = title
        this.description = description
        this.imgUrl = imgUrl
        this.publishDate = publishDate
        this.html_url = newsUrl
    }
}