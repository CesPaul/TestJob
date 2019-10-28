package com.cespaul.testjob.ui.news

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.cespaul.testjob.R
import com.cespaul.testjob.base.BaseActivity
import com.cespaul.testjob.model.News
import com.facebook.drawee.backends.pipeline.Fresco
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity<NewsPresenter>(), NewsView {
    private val newsAdapter = NewsAdapter(this)
    private val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_news)
        newsRecycler.adapter = newsAdapter
        newsRecycler.layoutManager = layoutManager
        val progressBar = loadBar
        progressBar.visibility = View.GONE

        newsRecycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }


    override fun updateNews(news: List<News>) {
        newsAdapter.updateNews(news)
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
