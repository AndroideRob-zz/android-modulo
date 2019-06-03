package com.konarskirob.data.article

import androidx.lifecycle.LiveData

interface ArticleRepo {

    val article: LiveData<Article>

    fun update(article: Article)

    companion object {

        fun create(): ArticleRepo = ArticleRepoImpl()
    }
}