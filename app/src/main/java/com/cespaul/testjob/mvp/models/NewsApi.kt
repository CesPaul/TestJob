package com.cespaul.testjob.mvp.models

import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {

    companion object News {
        val BaseUrl: String
            get() = "https://newsapi.org/v2/everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907&page="
    }
    @GET("1")
    fun getNews(): Call<List<News>>



}