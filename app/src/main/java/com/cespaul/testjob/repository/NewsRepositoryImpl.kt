package com.cespaul.testjob.repository

import com.cespaul.testjob.model.Articles
import com.cespaul.testjob.network.NewsApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    private var lastPageNumber: Int = 0
    private var currentArticles: Articles = Articles(ArrayList())

    override fun getNews(page: Int): Observable<Articles> {
        return newsApi
            .getNews(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun addNextPage(pageNumber: Int, page: Articles) {
        lastPageNumber = pageNumber
        val list = ArrayList(currentArticles.articles)
        list.addAll(page.articles)
        currentArticles = Articles(list)
    }

    override fun getAllPages(): Articles {
        return currentArticles
    }

    override fun getLastPageNumber(): Int {
        return lastPageNumber
    }
}