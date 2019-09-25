package com.cespaul.testjob.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cespaul.testjob.R
import com.cespaul.testjob.ui.news.NewsActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(
            applicationContext,
            NewsActivity::class.java
        )
        startActivity(intent)
        finish()
    }
}
