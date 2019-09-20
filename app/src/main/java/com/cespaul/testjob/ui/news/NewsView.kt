package com.cespaul.testjob.ui.news

import com.cespaul.testjob.model.News
import com.cespaul.testjob.base.BaseView

interface NewsView : BaseView {
    fun updateNews(news : List<News>)
    fun showToast(message : String)
    fun showProgress()
    fun hideProgress()
}