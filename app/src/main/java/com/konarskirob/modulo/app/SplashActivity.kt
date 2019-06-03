package com.konarskirob.modulo.app

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.konarskirob.data.article.Article
import com.konarskirob.data.article.ArticleRepo
import com.konarskirob.di.baseComponent
import com.konarskirob.modulo.R
import com.konarskirob.modulo.app.di.DaggerAppComponent
import com.konarskirob.navigation.Nav
import javax.inject.Inject

class SplashActivity : Activity() {

    lateinit var articleRepo: ArticleRepo
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DaggerAppComponent.builder().baseComponent(baseComponent()).build().inject(this)

        articleRepo.update(Article("1", "2"))
        Log.e("Article", articleRepo.article.value?.toString())

        Handler().postDelayed({
            startActivity(Nav.List.intent(this))
            finish()
        }, 1000)
    }
}