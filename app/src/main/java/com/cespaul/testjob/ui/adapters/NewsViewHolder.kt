package com.cespaul.testjob.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.cespaul.testjob.R
import com.cespaul.testjob.mvp.models.NewsDTO

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var lblNewsTitle: TextView?
    private var imgNewsThumb: ImageView?

    init{
       imgNewsThumb = itemView.findViewById<ImageView>(R.id.imgNewsThumb)
       lblNewsTitle = itemView.findViewById<TextView>(R.id.lblNewsTitle)
    }

    fun updateNews(news: NewsDTO) {
        lblNewsTitle?.text = news.toString()
    }

}