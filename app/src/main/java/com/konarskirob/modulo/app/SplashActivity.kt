package com.konarskirob.modulo.app

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.konarskirob.data.Article
import com.konarskirob.data.ArticleRepo
import com.konarskirob.di.BaseComponentProvider
import com.konarskirob.modulo.R
import com.konarskirob.modulo.app.di.DaggerAppComponent
import com.konarskirob.navigation.Nav
import javax.inject.Inject

class SplashActivity : Activity() {

    lateinit var bitch: ArticleRepo
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DaggerAppComponent.builder().baseComponent(baseComponent()).build().inject(this)

        bitch.update(Article("1", "2"))

        Log.e("Article", bitch.article.value?.toString())

        Handler().postDelayed({
            startActivity(Nav.List.intent(this))
            finish()
        }, 10000)
    }
}

fun Activity.baseComponent() =
    (applicationContext as? BaseComponentProvider)?.provideBaseComponent()
        ?: throw IllegalStateException("BaseComponentProvider not implemented: $applicationContext")