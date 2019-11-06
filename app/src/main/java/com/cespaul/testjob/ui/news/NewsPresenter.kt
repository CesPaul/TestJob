package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BasePresenter
import com.cespaul.testjob.model.Articles
import com.cespaul.testjob.network.NewsApi
import com.cespaul.testjob.repository.NewsRepository
import com.cespaul.testjob.repository.NewsRepositoryImpl
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewsPresenter(newsView: NewsView) : BasePresenter<NewsView>(newsView) {
    @Inject
    lateinit var newsApi: NewsApi

    var repository: NewsRepository = NewsRepositoryImpl(newsApi)

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        subscription = loadNewsFromInternet()
            .doOnTerminate { view.hideProgress() }
            .subscribe(
                { newsList -> view.updateNews(newsList) },
                { view.showToast("Error") }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadNewsFromInternet(): Observable<Articles> {
        view.showProgress()
        return repository
            .getNews(1)
    }
}