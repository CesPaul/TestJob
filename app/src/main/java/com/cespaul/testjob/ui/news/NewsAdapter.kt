package com.cespaul.testjob.ui.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cespaul.testjob.R
import com.cespaul.testjob.model.News
import kotlinx.android.synthetic.main.news_row.*
import kotlinx.android.synthetic.main.news_row.view.*


class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    private var newsList : List<News> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_row, parent, false))
    }

    override fun getItemCount() : Int {
        return newsList.size
    }

    override fun onBindViewHolder(holderNews: NewsViewHolder, position: Int) {
        val news = newsList.get(position)

        holderNews.titleTextView.text = news.title
        holderNews.descTextView.text = news.url

    }

    fun updateNews(news: List<News>){
        this.newsList = news
        notifyDataSetChanged()
    }

    class NewsViewHolder(private val itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView : TextView
        var descTextView : TextView
        init {
            titleTextView = itemLayoutView.lblNewsTitle
            descTextView = itemLayoutView.lblNewsDescription

        }
    }


}

