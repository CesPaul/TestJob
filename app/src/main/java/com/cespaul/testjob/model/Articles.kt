package com.cespaul.testjob.model

import com.google.gson.annotations.SerializedName

/**
 * Модель страницы с новостными статьсями.
 * Используется для парсинга JSON.
 *
 * @property articles Список новостных статей.
 */
data class Articles(
    @SerializedName("articles")
    val articles: List<Article>
)