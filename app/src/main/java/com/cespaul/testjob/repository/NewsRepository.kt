package com.cespaul.testjob.repository

import com.cespaul.testjob.model.Articles
import io.reactivex.Observable

interface NewsRepository {
    fun updateNews(page: Int): Observable<Articles>
    fun addNextPage(pageNumber: Int, page: Articles)
    fun getNewsFromDb(): Articles
    fun getAllPages(): Articles
    fun getLastPageNumber(): Int
}