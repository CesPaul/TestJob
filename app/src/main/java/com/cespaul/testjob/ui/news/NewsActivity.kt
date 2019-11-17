package com.cespaul.testjob.ui.news

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.cespaul.testjob.R
import com.cespaul.testjob.base.BaseActivity
import com.cespaul.testjob.model.Articles
import com.cespaul.testjob.ui.ArticleBrowse
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Отображает новостную ленту с возможность открытия статей.
 *
 */
class NewsActivity : BaseActivity<NewsPresenter>(), NewsView {

    private val newsAdapter = NewsAdapter(this) { position, item ->
        intent = Intent(getContext(), ArticleBrowse::class.java)
        intent.putExtra("url", item.url)
        startActivity(intent)
    }
    private val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_news)
        newsRecycler.adapter = newsAdapter
        newsRecycler.layoutManager = layoutManager

        newsRecycler.addOnScrollListener(
            OnScrollToBottomListener {
                presenter.loadNextPage()
            }
        )
        retryButton.setOnClickListener {
            presenter.loadNextPage()
        }

        setSupportActionBar(toolbar_actionbar)
        newsRecycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateNews(articles: Articles) {
        newsAdapter.updateNews(articles)
    }

    override fun showErrorBox() {
        val errorBox = errorBox
        errorBox.visibility = View.VISIBLE
    }

    override fun hideErrorBox() {
        val errorBox = errorBox
        errorBox.visibility = View.GONE
    }

    override fun showProgress() {
        val progressBar = loadBar
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        val progressBar = loadBar
        progressBar.visibility = View.GONE
    }

    override fun instantiatePresenter(): NewsPresenter {
        return NewsPresenter(this)
    }

}
