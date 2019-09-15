package com.cespaul.testjob.Retrofit

import com.cespaul.testjob.Model.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getNews(): Call<List<News>>

}