package com.cespaul.testjob

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_article_browse.*
import kotlinx.android.synthetic.main.toolbar.*

class ArticleBrowse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_browse)
        setSupportActionBar(toolbar_actionbar)
        val url = intent.getStringExtra("url")
        articleWebView.loadUrl(url)
        val webSettings = articleWebView.settings
        webSettings.javaScriptEnabled
        articleWebView.webViewClient = WebViewClient()
    }
}
