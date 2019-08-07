package com.cespaul.testjob.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle
import com.cespaul.testjob.R


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent = Intent(
            applicationContext,
            MainScreen::class.java
        )
        startActivity(intent)
        finish()
    }
}
