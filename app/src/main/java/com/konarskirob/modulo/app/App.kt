package com.konarskirob.modulo.app

import android.app.Application
import com.konarskirob.di.BaseComponent
import com.konarskirob.di.BaseComponentProvider
import com.konarskirob.di.BaseModule
import com.konarskirob.di.DaggerBaseComponent
import com.konarskirob.info.di.DaggerInfoComponent
import com.konarskirob.info.di.InfoComponent
import com.konarskirob.info.di.InfoComponentProvider
import com.konarskirob.list.di.DaggerListComponent
import com.konarskirob.list.di.ListComponent
import com.konarskirob.list.di.ListComponentProvider
import com.konarskirob.list.di.ListRouterComponent
import com.konarskirob.modulo.app.routers.ListRouterImpl

class App : Application(), BaseComponentProvider, ListComponentProvider, InfoComponentProvider {

    private val baseComponent: BaseComponent by lazy {
        DaggerBaseComponent.builder()
            .baseModule(BaseModule(this))
            .build()
    }

    private val listComponent: ListComponent by lazy {
        DaggerListComponent.builder()
            .baseComponent(baseComponent)
            .listRouterComponent(object : ListRouterComponent {
                override fun router() = ListRouterImpl()
            }).build()
    }

    private val infoComponent: InfoComponent by lazy {
        DaggerInfoComponent.builder()
            .baseComponent(baseComponent)
            .build()
    }

    override fun provideBaseComponent() = baseComponent
    override fun provideListComponent() = listComponent
    override fun provideInfoComponent() = infoComponent
}