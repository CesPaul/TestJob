package com.cespaul.testjob.repository

import com.cespaul.testjob.model.Articles
import com.cespaul.testjob.network.NewsApi
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepositoryImpl(private val newsApi : NewsApi): NewsRepository {

    override fun getNews(page: Int): Observable<Articles> {
        return newsApi
            .getNews(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}