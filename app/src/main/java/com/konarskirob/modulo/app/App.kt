package com.konarskirob.modulo.app

import android.app.Application
import com.konarskirob.di.BaseComponent
import com.konarskirob.di.BaseComponentProvider
import com.konarskirob.di.BaseModule
import com.konarskirob.di.DaggerBaseComponent

class App : Application(), BaseComponentProvider {

    private lateinit var baseComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent.builder()
            .baseModule(BaseModule(this))
            .build()
    }

    override fun provideBaseComponent() = baseComponent
}