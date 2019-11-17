package com.cespaul.testjob.di.component

import com.cespaul.testjob.base.BaseView
import com.cespaul.testjob.di.module.ContextModule
import com.cespaul.testjob.di.module.NetworkModule
import com.cespaul.testjob.ui.news.NewsPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Компонент для внедрения зависимостей.
 *
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])

/**
 * Управление внедрением зависимостей.
 *
 */
interface PresenterInjector {
    /**
     * Метод для внедрения зависимостей.
     *
     * @param newsPresenter Презентер для новостей.
     */
    fun inject(newsPresenter: NewsPresenter)

    /**
     * Управление созданием зависимостей.
     *
     */
    @Component.Builder
    interface Builder {
        /**
         * Создание зависимости.
         *
         * @return Injector.
         */
        fun build(): PresenterInjector

        /**
         * Модуль для сети.
         *
         * @param networkModule Экземпляр модуля сети.
         * @return Builder.
         */
        fun networkModule(networkModule: NetworkModule): Builder

        /**
         * Модуль для контекста.
         *
         * @param contextModule Модуль контекста.
         * @return Builder.
         */
        fun contextModule(contextModule: ContextModule): Builder

        /**
         * Привязка к конкретной реализации базовой View.
         *
         * @param baseView Базовая View
         * @return Builder.
         */
        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}