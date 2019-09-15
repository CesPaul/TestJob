package com.cespaul.testjob.View

import com.arellomobile.mvp.MvpView

interface MainContractView : MvpView {
    fun showToast(message : String)
    fun showProgress()
    fun hideProgress()
}