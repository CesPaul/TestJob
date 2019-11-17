package com.cespaul.testjob.repository

import com.cespaul.testjob.model.Articles
import io.reactivex.Observable

/**
 * Хранение и получение новостей.
 *
 */
interface NewsRepository {
    /**
     * Запускает задачу на загрузку новой страницы новостей.
     *
     * @param page Номер страницы.
     * @return Observable для страницы новостей.
     */
    fun updateNews(page: Int): Observable<Articles>

    /**
     * Добавление следующей страницы новостей в кэш.
     *
     * @param pageNumber Номер страницы новостей.
     * @param page Содержимое страницы новостей.
     */
    fun addNextPage(pageNumber: Int, page: Articles)

    /**
     * Получение всех закешированных новостей из базы данных.
     *
     * @return Все закешированные новости.
     */
    fun getNewsFromDb(): Articles

    /**
     * Получение всех уже загруженных новостей.
     *
     * @return Загруженные новости.
     */
    fun getAllPages(): Articles

    /**
     * Получение номера последней добавленной страницы.
     *
     * @return Номер страницы.
     */
    fun getLastPageNumber(): Int
}