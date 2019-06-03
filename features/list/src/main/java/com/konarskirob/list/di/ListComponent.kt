package com.konarskirob.list.di

import com.konarskirob.list.ListActivity
import dagger.Component

@Component
interface ListComponent  {

    fun inject(activity: ListActivity)
}