package com.cespaul.testjob.mvp.models.Retrofit

import com.cespaul.testjob.mvp.models.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("photos")
    fun getNews(): Call<List<DataModel>>
}