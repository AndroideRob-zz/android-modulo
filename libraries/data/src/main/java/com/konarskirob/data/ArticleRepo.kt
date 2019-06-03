package com.konarskirob.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ArticleRepo {

    val article: LiveData<Article>

    fun update(article: Article)
}

internal class ArticleRepoImpl : ArticleRepo {

    override val article = MutableLiveData<Article>()

    override fun update(article: Article) = this.article.postValue(article)
}