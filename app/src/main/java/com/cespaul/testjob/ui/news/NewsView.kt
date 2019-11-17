package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.model.Articles

/**
 * Интерфейс для View, которая отображает список новостей.
 *
 */
interface NewsView : BaseView {
    /**
     * Обновляет список новостей на экране.
     *
     * @param articles Это список новостей.
     */
    fun updateNews(articles: Articles)

    /**
     * Отображает информацию об ошибке загрузки новостей.
     *
     */
    fun showErrorBox()

    /**
     * Скрывает информацию об ошибке загрузки новостей.
     *
     */
    fun hideErrorBox()

    /**
     * Показывает Progress Bar.
     * Нужен в момент загрузки, чтобы показать пользователю, что процесс загрузки идёт.
     *
     */
    fun showProgress()

    /**
     * Скрывает Progress Bar.
     * Используется после окончания процесса загрузки.
     *
     */
    fun hideProgress()
}