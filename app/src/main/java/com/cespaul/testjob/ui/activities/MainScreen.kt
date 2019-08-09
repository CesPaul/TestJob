package com.cespaul.testjob.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.cespaul.testjob.R
import com.cespaul.testjob.mvp.models.GetNewsService
import com.cespaul.testjob.mvp.models.NewsDTO
import com.cespaul.testjob.mvp.models.NewsList
import com.cespaul.testjob.mvp.models.RetrofitClientInstance
import com.cespaul.testjob.mvp.views.MainView
import com.cespaul.testjob.ui.adapters.NewsAdapter
import kotlinx.android.synthetic.main.activity_main_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainScreen : MvpActivity(), MainView {

    private var allNews = ArrayList<NewsDTO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val service = RetrofitClientInstance.retrofitInstance?.create(GetNewsService::class.java)
        val call = service?.getAllNews()
        call?.enqueue(object : Callback<NewsList> {
            override fun onResponse(call: Call<NewsList>?, response: Response<NewsList>?) {
                val body = response?.body()
                /*val news = body?.news
                var size = news?.size*/
                /*val adapter = ArrayAdapter<NewsDTO>(applicationContext, android.R.layout.simple_list_item_1, news)
                actPlantName.setAdapter(adapter)*/
            }

            override fun onFailure(call: Call<NewsList>?, t: Throwable?) {
                Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_LONG).show()
            }
        })

        /*val recyclerView: RecyclerView = findViewById(R.id.newsRecyclerView)
        recyclerView.hasFixedSize()
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.adapter = NewsAdapter(allNews, R.layout.row_layout)*/

        //val retrofit = Retrofit.Builder().baseUrl(NewsApiService.BaseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
}
