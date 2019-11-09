package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BasePresenter
import com.cespaul.testjob.network.NewsApi
import com.cespaul.testjob.repository.NewsRepository
import com.cespaul.testjob.repository.NewsRepositoryImpl
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewsPresenter(newsView: NewsView) : BasePresenter<NewsView>(newsView) {
    @Inject
    lateinit var newsApi: NewsApi

    var repository: NewsRepository = NewsRepositoryImpl(newsApi)

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        subscription = loadNewsFromInternet(1)
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadNewsFromInternet(page: Int): Disposable? {
        view.showProgress()
        return repository
            .getNews(page)
            .doOnTerminate { view.hideProgress() }
            .subscribe(
                { newsList ->
                    repository.addNextPage(page, newsList)
                    view.updateNews(repository.getAllPages())
                },
                { view.showToast("Error") }
            )
    }

    fun loadNextPage() {
        if (repository.getLastPageNumber() < 5)
            loadNewsFromInternet(repository.getLastPageNumber() + 1)
    }
}