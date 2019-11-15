package com.cespaul.testjob.data.network

import com.cespaul.testjob.model.Articles
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907")
    fun getNews(@Query("page") page: Int): Observable<Articles>
}