package com.cespaul.testjob.components.ui

import android.os.Bundle
import com.cespaul.testjob.R
import com.cespaul.testjob.abstracts.presenter.MainScreenPresenter
import com.cespaul.testjob.abstracts.view.BaseCompatActivity
import com.cespaul.testjob.components.backstage.MainScreenContract

class MainScreen : BaseCompatActivity(), MainScreenContract.View {
    val presenter: MainScreenPresenter? = MainScreenPresenter()
    override fun init(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main_screen)
        presenter?.attach(this)
    }
}
