package com.cespaul.testjob.ui.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cespaul.testjob.R
import com.cespaul.testjob.model.Article
import com.cespaul.testjob.model.Articles
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.news_row.view.*
import java.text.SimpleDateFormat
import java.util.*


class NewsAdapter(private val context: Context) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var articlesList: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.news_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holderNews: NewsViewHolder, position: Int) {
        val articles = articlesList.get(position)
        holderNews.titleTextView.text = articles.title
        holderNews.descTextView.text = articles.description
        holderNews.publishedAtTextView.text = articles.publishedAt
        holderNews.imgNewsView.setImageURI(articles.urlToImage)
    }

    fun updateNews(articleNews: Articles) {
        this.articlesList = articleNews.articles
        notifyDataSetChanged()
    }

    class NewsViewHolder(private val itemLayoutView: View) :
        RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView: TextView
        var descTextView: TextView
        var publishedAtTextView: TextView
        var imgNewsView: SimpleDraweeView

        init {
            titleTextView = itemLayoutView.lblNewsTitle
            descTextView = itemLayoutView.lblNewsDescription
            publishedAtTextView = itemLayoutView.lblPublishedAt
            imgNewsView = itemLayoutView.imgNews
        }
    }


}

