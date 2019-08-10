package com.cespaul.testjob.ui.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.MvpActivity
import com.cespaul.testjob.R
import com.cespaul.testjob.mvp.models.Retrofit.ApiClient
import com.cespaul.testjob.mvp.models.DataModel
import com.cespaul.testjob.mvp.views.MainView
import com.cespaul.testjob.ui.adapters.DataAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreen : MvpActivity(), MainView {


    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = DataAdapter(dataList,this)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        progerssProgressDialog= ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()

    }
    private fun getData() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getNews()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()
            }

        })
    }
}
