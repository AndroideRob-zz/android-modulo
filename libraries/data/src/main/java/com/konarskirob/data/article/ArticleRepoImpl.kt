package com.konarskirob.data.article

import androidx.lifecycle.MutableLiveData


internal class ArticleRepoImpl : ArticleRepo {

    override val article = MutableLiveData<Article>()

    override fun update(article: Article) {
        this.article.value = article
    }
}