package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BasePresenter
import com.cespaul.testjob.data.database.NewsDatabase
import com.cespaul.testjob.data.network.NewsApi
import com.cespaul.testjob.repository.NewsRepository
import com.cespaul.testjob.repository.NewsRepositoryImpl
import com.cespaul.testjob.utils.API_KEY_MAX_NEWS_NUMBER_LIMIT
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 *  Отвечает за логику работы и взыаимодействия.
 *
 * @constructor
 *
 *
 * @param newsView Экземпляр новостной View.
 */
class NewsPresenter(newsView: NewsView) : BasePresenter<NewsView>(newsView) {
    private var isLoading: Boolean = false
    private var storageMode = StorageMode.API
    @Inject
    lateinit var newsApi: NewsApi
    @Inject
    lateinit var newsDb: NewsDatabase
    private var repository: NewsRepository = NewsRepositoryImpl(newsApi, newsDb)

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        view.hideErrorBox() // Начальное сокрытие сообщения.
        subscription = loadNews(1)
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    /**
     * Загрузка новостей.
     * Показывает индикацию загрузки.
     * В случае успеха загрузки страницы с новостями - кэширует их в память.
     * В случае ошибки загрузки страницы - загружает новости из базы данных
     *  и предлагает повторить попытку загрузки.
     *
     * @param page Номер загружаемой страницы из API.
     * @return Observable для страницы новостей.
     */
    private fun loadNews(page: Int): Disposable? {
        isLoading = true
        view.hideErrorBox() // Скрытие сообщения об ошибке из кода в начале.
        view.showProgress()
        return repository
            .updateNews(page)
            .doOnTerminate { view.hideProgress() }
            .subscribe({ newsList ->
                storageMode = StorageMode.API
                repository.addNextPage(page, newsList)
                view.updateNews(repository.getAllPages())
                isLoading = false
            }, {
                view.hideProgress()
                isLoading = false
                storageMode = StorageMode.DATABASE
                view.showErrorBox()
                view.updateNews(repository.getNewsFromDb())
            })
    }

    /**
     * Выполняет загрузка следующей страницы.
     * Проверяет предел страниц.
     *
     */
    fun loadNextPage() {
        if (isLoading) {
            return
        }
        if (repository.getLastPageNumber() < API_KEY_MAX_NEWS_NUMBER_LIMIT) {
            loadNews(repository.getLastPageNumber() + 1)
        }
    }
}