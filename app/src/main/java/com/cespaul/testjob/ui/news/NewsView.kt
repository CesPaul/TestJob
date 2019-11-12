package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.model.Articles

interface NewsView : BaseView {
    fun updateNews(articles: Articles)
    fun showErrorMessage()
    fun hideErrorMessage()
    fun showProgress()
    fun hideProgress()
}