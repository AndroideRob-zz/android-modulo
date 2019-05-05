package com.konarskirob.list

import android.content.Context
import android.content.Intent

class ListFeature(private val context: Context) {

    fun getIntent(): Intent = ListActivity.newIntent(context)
}