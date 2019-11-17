package com.cespaul.testjob.repository

import com.cespaul.testjob.data.database.NewsDatabase
import com.cespaul.testjob.data.network.NewsApi
import com.cespaul.testjob.model.Articles
import com.cespaul.testjob.utils.PAGE_SIZE
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class NewsRepositoryImpl(private val newsApi: NewsApi, private val newsDb: NewsDatabase) :
    NewsRepository {

    private var lastPageNumber: Int = 0
    private var currentArticles: Articles = Articles(ArrayList())

    override fun updateNews(page: Int): Observable<Articles> {
        return newsApi
            .getNews(PAGE_SIZE, page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun addNextPage(pageNumber: Int, page: Articles) {
        // Memory cache.
        lastPageNumber = pageNumber
        val list = ArrayList(currentArticles.articles)
        list.addAll(page.articles)
        currentArticles = Articles(list)

        // Room cache.
        if (pageNumber == 1) {
            newsDb.newsDao().clearNews()
        }
        newsDb.newsDao().insertArticle(page.articles)
    }

    override fun getNewsFromDb(): Articles {
        return Articles(newsDb.newsDao().selectArticles())
    }

    override fun getAllPages(): Articles {
        return currentArticles
    }

    override fun getLastPageNumber(): Int {
        return lastPageNumber
    }
}