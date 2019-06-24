package com.konarskirob.list.di

import com.konarskirob.di.AppScope
import com.konarskirob.di.BaseComponent
import com.konarskirob.list.ListActivity
import com.konarskirob.list.ListRouter
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [BaseComponent::class, ListRouterComponent::class])
@AppScope
interface ListComponent {

    fun listRouter(): ListRouter

    fun inject(activity: ListActivity)
}

interface ListRouterComponent {
    fun router(): ListRouter
}