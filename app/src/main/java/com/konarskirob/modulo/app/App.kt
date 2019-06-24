package com.konarskirob.modulo.app

import android.app.Application
import com.konarskirob.di.*
import com.konarskirob.list.ListRouter
import com.konarskirob.list.di.DaggerListComponent
import com.konarskirob.list.di.ListComponent
import com.konarskirob.list.di.ListComponentProvider
import com.konarskirob.list.di.ListRouterComponent
import com.konarskirob.modulo.app.routers.ListRouterImpl

class App : Application(), BaseComponentProvider, ListComponentProvider {

    private lateinit var baseComponent: BaseComponent

    private lateinit var listComponent: ListComponent

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent.builder()
            .baseModule(BaseModule(this))
            .topicsModule(TopicsModule())
            .build()

        listComponent = DaggerListComponent.builder()
            //.baseComponent(baseComponent)
            .listRouterComponent(object : ListRouterComponent {
                override fun router() = ListRouterImpl()
            })
            .build()
    }

    override fun provideBaseComponent() = baseComponent

    override fun provideListComponent() = listComponent
}