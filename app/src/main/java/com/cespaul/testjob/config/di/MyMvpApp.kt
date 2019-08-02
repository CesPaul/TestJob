package com.cespaul.testjob.config.di

import android.app.Application
import android.content.Context
import com.cespaul.testjob.components.backstage.di.MainScreenModule
import javax.inject.Inject

class MyMvpApp : Application() {
    lateinit var injector : AppDiComponent
    private set

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
        injector = DaggerAppDiComponent.builder()
            .mainScreenModule(MainScreenModule())
            .build()
    }

    companion object {
        private var INSTANCE: MyMvpApp? = null
        @JvmStatic
        fun get(): MyMvpApp = INSTANCE!!
    }
}