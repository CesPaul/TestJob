package com.cespaul.testjob.ui.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.cespaul.testjob.R
import com.cespaul.testjob.Model.News
import com.cespaul.testjob.View.MainContractView
import com.cespaul.testjob.ui.adapters.DataAdapter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() , MainContractView {

    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<News>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        recyclerView.adapter = DataAdapter(dataList,this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        showProgress()
    }

    override fun showToast(message : String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
    }
    override fun hideProgress() {
        progressDialog.dismiss()
    }
}
