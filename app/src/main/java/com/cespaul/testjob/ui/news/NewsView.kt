package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.model.Articles

interface NewsView : BaseView {
    fun updateNews(articles: Articles)
    fun showErrorBox()
    fun hideErrorBox()
    fun showProgress()
    fun hideProgress()
}