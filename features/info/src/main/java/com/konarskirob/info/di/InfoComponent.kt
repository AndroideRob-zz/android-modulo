package com.konarskirob.info.di

import com.konarskirob.di.AppScope
import com.konarskirob.di.BaseComponent
import com.konarskirob.info.InfoFragment
import dagger.Component

@Component(dependencies = [BaseComponent::class])
@AppScope
interface InfoComponent {

    fun inject(fragment: InfoFragment)
}