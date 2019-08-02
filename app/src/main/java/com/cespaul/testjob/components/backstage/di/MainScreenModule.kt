package com.cespaul.testjob.components.backstage.di
import com.cespaul.testjob.abstracts.presenter.MainScreenPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainScreenModule {
    @Provides
    @Singleton
    fun providesPresenter() : MainScreenPresenter = MainScreenPresenter()
}