package com.konarskirob.modulo.app.di

import com.konarskirob.di.BaseAppScope
import com.konarskirob.di.BaseComponent
import com.konarskirob.modulo.app.SplashActivity
import dagger.Component

@Component(dependencies = [BaseComponent::class])
@BaseAppScope
interface AppComponent {

    fun inject(activity: SplashActivity)
}