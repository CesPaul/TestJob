package com.cespaul.testjob.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cespaul.testjob.R
import com.cespaul.testjob.ui.news.NewsActivity


/**
 * Для отображения во время загруки приложения.
 *
 */
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
