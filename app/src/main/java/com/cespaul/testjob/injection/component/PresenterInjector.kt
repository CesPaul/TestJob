package com.cespaul.testjob.injection.component

import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.injection.module.ContextModule
import com.cespaul.testjob.injection.module.NetworkModule
import com.cespaul.testjob.ui.news.NewsPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(ContextModule::class),(NetworkModule::class)])

interface PresenterInjector {
    fun inject(newsPresenter: NewsPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule) : Builder
        fun contextModule(contextModule: ContextModule) : Builder

        @BindsInstance
        fun baseView(baseView: BaseView) : Builder
    }
}