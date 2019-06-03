package com.konarskirob.list.di

import com.konarskirob.di.AppScope
import com.konarskirob.di.BaseComponent
import com.konarskirob.list.ListActivity
import dagger.Component

@Component(dependencies = [BaseComponent::class])
@AppScope
interface ListComponent  {

    fun inject(activity: ListActivity)
}