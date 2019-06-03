package com.konarskirob.modulo.app.di

import com.konarskirob.di.AppScope
import com.konarskirob.di.BaseComponent
import com.konarskirob.modulo.app.SplashActivity
import dagger.Component

@Component(dependencies = [BaseComponent::class])
@AppScope
interface AppComponent {

    fun inject(activity: SplashActivity)
}