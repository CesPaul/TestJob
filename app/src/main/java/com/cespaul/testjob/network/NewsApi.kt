package com.cespaul.testjob.network

import com.cespaul.testjob.Model.News
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface NewsApi {
    @GET("/photos")
    fun getNews(): Observable<List<News>>
}