package com.konarskirob.di

import com.konarskirob.data.topics.InfoTopic
import com.konarskirob.data.topics.LocationTopic
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TopicsModule {

    @Provides
    @Singleton
    fun provideLocationTopic() = LocationTopic()

    @Provides
    @Singleton
    fun provideInfoTopic() = InfoTopic()
}