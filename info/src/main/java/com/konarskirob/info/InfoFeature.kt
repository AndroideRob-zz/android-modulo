package com.konarskirob.info

import androidx.fragment.app.Fragment

class InfoFeature(private val callback: () -> Unit) {

    fun getFragment(): Fragment = InfoFragment.newInstance(callback)
}