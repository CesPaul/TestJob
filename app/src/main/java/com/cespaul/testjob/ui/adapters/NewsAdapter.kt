package com.cespaul.testjob.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cespaul.testjob.R
import com.cespaul.testjob.mvp.models.NewsDTO
import kotlinx.android.synthetic.main.news_row.view.*


class NewsAdapter(private val news: MutableList<NewsDTO>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.newsTitle.text = news[position].newsTitle
        holder.nwwsDescription.text = news[position].newsDecription
        holder.newsDate.text = news[position].newsPublishDate
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsTitle = view.lblNewsTitle
        val nwwsDescription = view.lblNewsDescription
        val newsDate = view.lblNewsDate
    }


}

