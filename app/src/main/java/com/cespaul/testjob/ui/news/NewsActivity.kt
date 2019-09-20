package com.cespaul.testjob.ui.news

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.cespaul.testjob.R
import com.cespaul.testjob.model.News
import com.cespaul.testjob.base.BaseActivity
import com.cespaul.testjob.utils.setDividerItemDecoration
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity<NewsPresenter>(), NewsView {

    lateinit var progressDialog: ProgressDialog
    private val newsAdapter = NewsAdapter(this)
    private val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        newsRecycler.adapter = newsAdapter
        newsRecycler.layoutManager = layoutManager

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
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
    }
    override fun hideProgress() {
        progressDialog.dismiss()
    }

    override fun instantiatePresenter(): NewsPresenter {
        return NewsPresenter(this)
    }

}
