package com.cespaul.testjob.mvp.models

import retrofit2.Call
import retrofit2.http.GET

interface GetNewsService {

    @GET("everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907&page=1")
    fun getAllNews(): Call<NewsList>

}