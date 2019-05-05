package com.konarskirob.navigation

import androidx.fragment.app.Fragment
import com.konarskirob.info.InfoFeature

class InfoHandle(callback: () -> Unit) {

    private val feature: InfoFeature by lazy {
        InfoFeature(callback)
    }

    fun getFragment(): Fragment = feature.getFragment()
}