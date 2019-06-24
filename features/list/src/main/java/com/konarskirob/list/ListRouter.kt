package com.konarskirob.list

import android.content.Context
import androidx.fragment.app.Fragment

interface ListRouter {

    fun provideInfoFragment(): Fragment

    fun routeToDetail(context: Context, id: String)
}