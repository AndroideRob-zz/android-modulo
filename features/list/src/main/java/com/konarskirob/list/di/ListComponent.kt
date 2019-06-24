package com.konarskirob.list.di

import com.konarskirob.list.ListActivity
import com.konarskirob.list.ListRouter
import dagger.Component

@Component(dependencies = [ListRouterComponent::class])
interface ListComponent {

    fun listRouter(): ListRouter

    fun inject(activity: ListActivity)
}

interface ListRouterComponent {
    fun router(): ListRouter
}