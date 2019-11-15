package com.cespaul.testjob.ui.news

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class OnScrollToBottomListener(
    private val onScrolledToBottom: () -> Unit
) : RecyclerView.OnScrollListener() {
    private var previousTotal = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager ?: return
        if (layoutManager is LinearLayoutManager) {
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

            if (totalItemCount > previousTotal) {
                previousTotal = totalItemCount
            }

            if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                onScrolledToBottom.invoke()
            }
        }
    }
}