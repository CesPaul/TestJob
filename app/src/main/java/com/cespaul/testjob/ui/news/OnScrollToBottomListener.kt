package com.cespaul.testjob.ui.news

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cespaul.testjob.utils.PREFETCH_SIZE

/**
 * Необходим для отслеживания прокрутки к концу списка видимых новостей.
 *
 * @property onScrolledToBottom Выполняет вызов метода загрузки новостей.
 */
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

            // Вычисление предельного элемента страницы.
            if (totalItemCount > previousTotal) {
                previousTotal = totalItemCount
            }

            /**
             * Вызов загрузки в случае достижения предельного количества элементов
             * с учётом размера префетчинга.
             */
            if (pastVisibleItems + visibleItemCount >= totalItemCount - PREFETCH_SIZE) {
                onScrolledToBottom.invoke()
            }
        }
    }
}