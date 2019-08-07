package com.cespaul.testjob.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.RelativeLayout
import com.arellomobile.mvp.MvpActivity
import com.cespaul.testjob.R
import com.cespaul.testjob.mvp.views.MainView


class MainScreen : MvpActivity(), MainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.cespaul.testjob.R.layout.activity_main_screen)
        val recyclerView: RecyclerView = findViewById(R.id.NewsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
