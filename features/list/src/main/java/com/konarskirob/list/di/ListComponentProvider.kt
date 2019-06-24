package com.konarskirob.list.di

import com.konarskirob.di.BaseComponent

interface ListComponentProvider {

    fun provideListComponent(): ListComponent
}