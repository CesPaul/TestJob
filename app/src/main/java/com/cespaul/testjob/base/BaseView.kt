package com.cespaul.testjob.base

import android.content.Context

/**
 * Основа для базовых View.
 *
 */
interface BaseView {

    /**
     * Получение контекста.
     *
     * @return Возвращает контекст.
     */
    fun getContext(): Context
}