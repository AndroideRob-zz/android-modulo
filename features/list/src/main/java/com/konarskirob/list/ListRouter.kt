package com.konarskirob.list

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

interface ListRouter {

    fun createInfoFragment(): Fragment

    fun createDetailIntent(context: Context, id: String): Intent
}