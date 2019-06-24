package com.konarskirob.list

import androidx.fragment.app.Fragment

interface ListRouter {

    fun provideInfoFragment(): Fragment

    fun routeToDetail(id: String)
}