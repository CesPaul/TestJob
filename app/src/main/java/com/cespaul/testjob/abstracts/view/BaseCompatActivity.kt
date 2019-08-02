package com.cespaul.testjob.abstracts.view

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseCompatActivity: AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        init(savedInstanceState)
    }

    protected abstract fun init(savedInstanceState: Bundle?)

    override fun getContext(): Context = this
}