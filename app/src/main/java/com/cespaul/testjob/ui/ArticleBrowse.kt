package com.cespaul.testjob.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.cespaul.testjob.R
import kotlinx.android.synthetic.main.activity_article_browse.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Отображает браузер с открытой новостной статьёй.
 * Сюда приходит url новостной статьи.
 *
 */
class ArticleBrowse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_browse)
        setSupportActionBar(toolbar_actionbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_actionbar.setNavigationOnClickListener { onBackPressed() }

        val url = intent.getStringExtra("url")

        // Настройка WebView
        articleWebView.loadUrl(url)
        val webSettings = articleWebView.settings
        webSettings.javaScriptEnabled
        articleWebView.webViewClient = WebViewClient()
    }
}
