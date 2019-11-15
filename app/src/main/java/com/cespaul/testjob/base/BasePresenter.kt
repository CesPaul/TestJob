package com.cespaul.testjob.base

import com.cespaul.testjob.di.component.DaggerPresenterInjector
import com.cespaul.testjob.di.component.PresenterInjector
import com.cespaul.testjob.di.module.ContextModule
import com.cespaul.testjob.di.module.NetworkModule
import com.cespaul.testjob.ui.news.NewsPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {
        when (this) {
            is NewsPresenter -> injector.inject(this)
        }
    }
}