package com.cespaul.testjob.network

import com.cespaul.testjob.model.News
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsApi {
    @GET("/photos")
    fun getNews(): Observable<List<News>>
}