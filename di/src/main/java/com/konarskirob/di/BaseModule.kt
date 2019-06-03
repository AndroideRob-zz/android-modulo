package com.konarskirob.di

import android.app.Application
import android.content.Context
import com.konarskirob.data.ArticleRepo
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class BaseModule(private val app: Application) {

    @Provides
    @Reusable
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideArticleRepo(): ArticleRepo = ArticleRepo.create()
}