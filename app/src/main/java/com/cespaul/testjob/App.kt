package com.cespaul.testjob

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Класс для инициализации фреско.
 *
 */
class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(instance)
    }
}