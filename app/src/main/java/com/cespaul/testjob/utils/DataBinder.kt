@file:Suppress("unused")

package com.cespaul.testjob.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.cespaul.testjob.ui.news.NewsAdapter

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: NewsAdapter){
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager : RecyclerView.LayoutManager){
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration){
    view.addItemDecoration(dividerItemDecoration)
}