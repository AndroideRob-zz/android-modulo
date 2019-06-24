package com.konarskirob.modulo.app.routers

import com.konarskirob.info.InfoFragment
import com.konarskirob.list.ListRouter

class ListRouterImpl : ListRouter {

    override fun provideInfoFragment() = InfoFragment()

    override fun routeToDetail(id: String) {
    }
}