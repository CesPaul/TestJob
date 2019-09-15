package com.cespaul.testjob.Presenter

import com.cespaul.testjob.Model.News
import com.cespaul.testjob.Retrofit.ApiClient
import com.cespaul.testjob.View.MainContractView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (internal var mainContractView: MainContractView) : MainContractPresenter {


    override fun getData() {
        val call: Call<List<News>> = ApiClient.getClient.getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>?, response: Response<List<News>>?) {
                mainContractView.hideProgress()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<List<News>>?, t: Throwable?) {
                mainContractView.hideProgress()
                mainContractView.showToast("Check Internet connection")
            }
        })
    }

}