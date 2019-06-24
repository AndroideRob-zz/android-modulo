package com.konarskirob.modulo.app.routers

import android.content.Context
import com.konarskirob.detail.DetailActivity
import com.konarskirob.info.InfoFragment
import com.konarskirob.list.ListRouter

class ListRouterImpl : ListRouter {

    override fun provideInfoFragment() = InfoFragment()

    override fun routeToDetail(context: Context, id: String) {
        val intent = DetailActivity.newIntent(context, id)
        context.startActivity(intent)
    }
}