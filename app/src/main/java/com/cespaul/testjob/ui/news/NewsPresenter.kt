package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BasePresenter
import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.network.NewsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsPresenter(newsView: NewsView) : BasePresenter<NewsView>(newsView) {
    @Inject
    lateinit var newsApi: NewsApi

    private var subscription : Disposable? = null

    override fun onViewCreated() {
        loadNews()
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadNews(){
        view.showProgress()
        subscription = newsApi
            .getNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate{ view.hideProgress() }
            .subscribe(
                { newsList -> view.updateNews(newsList) },
                { view.showToast("Error") }
            )
    }
}