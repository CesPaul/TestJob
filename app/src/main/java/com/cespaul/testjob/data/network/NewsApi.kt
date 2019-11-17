package com.cespaul.testjob.data.network

import com.cespaul.testjob.model.Articles
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Для загрузки новостей из сети Интернет.
 * Использует магию Retrofit2.
 *
 */
interface NewsApi {
    /**
     * Получение новостей с помощью get-запроса.
     *
     * @param pageSize Количество нвоостей на странице.
     * @param page Порядковый номер страницы с новостями.
     * @return Observable для страницы новостей.
     */
    @GET("everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907")
    fun getNews(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): Observable<Articles>
}