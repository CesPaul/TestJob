package com.cespaul.testjob.ui.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cespaul.testjob.R
import com.cespaul.testjob.mvp.models.NewsDTO
import com.cespaul.testjob.mvp.models.NewsList
import com.cespaul.testjob.ui.activities.MainScreen
import kotlinx.android.synthetic.main.activity_main_screen.*


class NewsAdapter{

    private lateinit var newsList: List<NewsList>
    private lateinit var context: Context

    constructor(newsList: List<NewsList>, context: Context) {
        this.newsList = newsList
        this.context = context
    }

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsTemp.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var news: NewsDTO = newsTemp.get(position)
        holder.updateNews(news)

        val newsList = NewsList.get(position)
    }*/

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var title: TextView


        fun ViewHolder(itemView: View){
            title = itemView.findViewById<View>(R.id.lblNewsTitle) as TextView
        }
    }
}

