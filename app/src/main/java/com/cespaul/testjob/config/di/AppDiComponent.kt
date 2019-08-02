package com.cespaul.testjob.config.di

import com.cespaul.testjob.components.backstage.di.MainScreenModule
import com.cespaul.testjob.components.ui.MainScreen
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        MainScreenModule::class
    ]
)
@Singleton
interface AppDiComponent {
    fun inject(mainScreen: MainScreen)
}