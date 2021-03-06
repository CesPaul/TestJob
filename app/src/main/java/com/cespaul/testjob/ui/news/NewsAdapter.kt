package com.cespaul.testjob.ui.news

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.cespaul.testjob.R
import com.cespaul.testjob.model.Article
import com.cespaul.testjob.model.Articles
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.news_row.view.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * Ответственнен за помещение новостей в RecyclerView.
 *
 * @property context Контекст.
 * @property onItemClickListener Отслеживание нажатия на элемент списка новостей.
 */
class NewsAdapter(
    private val context: Context,
    private val onItemClickListener: (position: Int, item: Article) -> Unit
) :
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
        val article = articlesList[position]
        holderNews.onItemClickListener = View.OnClickListener {
            onItemClickListener(position, article)
        }
        holderNews.titleTextView.text = article.title
        holderNews.descTextView.text = article.description
        holderNews.publishedAtTextView.text = convertDate(article.publishedAt)
        holderNews.imgNewsView.setImageURI(article.urlToImage)
        Log.e(TAG, "URI of Image" + article.urlToImage)
    }

    /**
     * Обновляет список новостей на экране.
     *
     * @param articleNews Список новостей.
     */
    fun updateNews(articleNews: Articles) {
        this.articlesList = articleNews.articles
        notifyDataSetChanged()
    }

    class NewsViewHolder(
        itemLayoutView: View
    ) :
        RecyclerView.ViewHolder(itemLayoutView) {
        var onItemClickListener: View.OnClickListener? = null
        var titleTextView: TextView = itemLayoutView.lblNewsTitle
        var descTextView: TextView = itemLayoutView.lblNewsDescription
        var publishedAtTextView: TextView = itemLayoutView.lblPublishedAt
        var imgNewsView: SimpleDraweeView = itemLayoutView.imgNews

        init {
            val drawable = CircularProgressDrawable(itemLayoutView.context)
            drawable.setStyle(CircularProgressDrawable.DEFAULT)
            drawable.centerRadius = 48.toFloat()
            imgNewsView.hierarchy.setProgressBarImage(drawable)
            itemLayoutView.setOnClickListener {
                onItemClickListener?.onClick(it)
            }
        }
    }

    /**
     * Преобразование даты и времени публикации новости в другой формат с подписью.
     *
     * @param publishedAt Дата и время публикации.
     * @return Строка с подписью и датой и временем по требуемому формату.
     */
    private fun convertDate(publishedAt: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date: Long = simpleDateFormat.parse(publishedAt).time
        var subtitle = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.getDefault()).format(Date(date))
        subtitle = context.getString(R.string.subtitle) + " " + subtitle
        return subtitle
    }
}

