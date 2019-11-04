package com.cespaul.testjob.ui.news

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.cespaul.testjob.R
import com.cespaul.testjob.base.BaseActivity
import com.cespaul.testjob.model.Articles
import com.facebook.drawee.backends.pipeline.Fresco
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.toolbar.*

class NewsActivity : BaseActivity<NewsPresenter>(), NewsView {
    private val newsAdapter = NewsAdapter(this)
    private val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_news)
        newsRecycler.adapter = newsAdapter
        newsRecycler.layoutManager = layoutManager
        initToolbar()
        newsRecycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar_actionbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar_actionbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun updateNews(articles: Articles) {
        newsAdapter.updateNews(articles)
    }

    override fun showToast(message : String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
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
