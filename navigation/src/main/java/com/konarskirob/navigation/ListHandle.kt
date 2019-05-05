package com.konarskirob.navigation

import android.content.Context
import com.konarskirob.list.ListFeature

class ListHandle(context: Context) {

    private val feature = ListFeature(context)

    fun getIntent() = feature.getIntent()
}