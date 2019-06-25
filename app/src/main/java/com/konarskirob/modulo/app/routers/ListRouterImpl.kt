package com.konarskirob.modulo.app.routers

import android.content.Context
import com.konarskirob.detail.DetailActivity
import com.konarskirob.info.InfoFragment
import com.konarskirob.list.ListRouter

class ListRouterImpl : ListRouter {

    override fun createInfoFragment() =
        InfoFragment()

    override fun createDetailIntent(context: Context, id: String) =
        DetailActivity.newIntent(context, id)
}