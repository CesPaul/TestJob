package com.cespaul.testjob.base

import android.view.View

abstract class BasePresenter<out v: BaseView>(protected val view : v) {
    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject(){
        //TODO: Impl this method
    }
}