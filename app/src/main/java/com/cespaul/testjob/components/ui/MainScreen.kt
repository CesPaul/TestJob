package com.cespaul.testjob.components.ui

import android.os.Bundle
import com.cespaul.testjob.R
import com.cespaul.testjob.abstracts.presenter.MainScreenPresenter
import com.cespaul.testjob.abstracts.view.BaseCompatActivity
import com.cespaul.testjob.components.backstage.MainScreenContract
import com.cespaul.testjob.config.di.MyMvpApp
import javax.inject.Inject

class MainScreen : BaseCompatActivity(), MainScreenContract.View {

    @Inject
    lateinit var presenter: MainScreenPresenter

    override fun init(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main_screen)
        MyMvpApp.get().injector.inject(this)
        presenter?.attach(this)
    }

}
