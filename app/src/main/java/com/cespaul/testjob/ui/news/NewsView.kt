package com.cespaul.testjob.ui.news

import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.model.News

interface NewsView : BaseView {
    fun updateNews(news : List<News>)
    fun showToast(message : String)
    fun showProgress()
    fun hideProgress()
}