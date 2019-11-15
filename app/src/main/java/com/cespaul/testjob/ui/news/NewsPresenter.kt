package com.cespaul.testjob.ui.news

import com.cespaul.testjob.App
import com.cespaul.testjob.base.BasePresenter
import com.cespaul.testjob.data.database.NewsDatabase
import com.cespaul.testjob.data.network.NewsApi
import com.cespaul.testjob.model.Article
import com.cespaul.testjob.repository.NewsRepository
import com.cespaul.testjob.repository.NewsRepositoryImpl
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewsPresenter(newsView: NewsView) : BasePresenter<NewsView>(newsView) {
    private var isLoading: Boolean = false
    private var storageMode = StorageMode.API
    @Inject
    lateinit var newsApi: NewsApi
    var newsDb: NewsDatabase = App.instance.getDatabase()
    var repository: NewsRepository = NewsRepositoryImpl(newsApi, newsDb)

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        view.hideErrorBox()
        subscription = loadNews(1)
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun loadNews(page: Int): Disposable? {
        isLoading = true
        view.hideErrorBox()
        view.showProgress()
        return repository
            .updateNews(page)
            .doOnTerminate { view.hideProgress() }
            .subscribe(
                { newsList ->
                    storageMode = StorageMode.API
                    repository.addNextPage(page, newsList)
                    view.updateNews(repository.getAllPages())
                    isLoading = false
                },
                {
                    view.hideProgress()
                    isLoading = false
                    /*if (storageMode == StorageMode.DATABASE) {
                        return@subscribe
                    }*/
                    storageMode = StorageMode.DATABASE
                    view.showErrorBox()
                    view.updateNews(repository.getNewsFromDb())
                }
            )
    }

    fun loadNextPage() {
        if (isLoading) {
            return
        }
        if (repository.getLastPageNumber() < 5) {
            loadNews(repository.getLastPageNumber() + 1)
        }
    }

    fun onBrowseArticle(article: Article) {

    }
}