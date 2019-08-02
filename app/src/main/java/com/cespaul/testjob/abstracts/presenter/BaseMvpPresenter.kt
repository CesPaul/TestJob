package com.cespaul.testjob.abstracts.presenter

import com.cespaul.testjob.abstracts.view.BaseView

interface BaseMvpPresenter<V: BaseView> {
    var isAttached: Boolean
    fun attach(view: V)
    fun detach()
}