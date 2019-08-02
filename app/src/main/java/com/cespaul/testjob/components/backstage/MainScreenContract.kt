package com.cespaul.testjob.components.backstage

import com.cespaul.testjob.abstracts.presenter.BaseMvpPresenter
import com.cespaul.testjob.abstracts.view.BaseView

interface MainScreenContract {
    interface Presenter: BaseMvpPresenter<View>
    interface View: BaseView
}