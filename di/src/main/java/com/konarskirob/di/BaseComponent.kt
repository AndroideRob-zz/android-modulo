package com.konarskirob.di

import com.konarskirob.data.ArticleRepo
import dagger.Component
import javax.inject.Singleton

@Component(modules = [BaseModule::class])
@Singleton
interface BaseComponent {

    fun articleRepo(): ArticleRepo
}