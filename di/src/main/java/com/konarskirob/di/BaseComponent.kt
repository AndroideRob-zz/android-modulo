package com.konarskirob.di

import com.konarskirob.data.article.ArticleRepo
import com.konarskirob.data.topics.InfoTopic
import com.konarskirob.data.topics.LocationTopic
import dagger.Component
import javax.inject.Singleton

@Component(modules = [BaseModule::class])
@Singleton
interface BaseComponent {

    fun articleRepo(): ArticleRepo

    fun infoTopic(): InfoTopic

    fun locationTopic(): LocationTopic
}