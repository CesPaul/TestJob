package com.cespaul.testjob.repository

import com.cespaul.testjob.model.Articles
import io.reactivex.Completable
import io.reactivex.Observable

interface NewsRepository {
    fun getNews(page: Int) : Observable<Articles>
}