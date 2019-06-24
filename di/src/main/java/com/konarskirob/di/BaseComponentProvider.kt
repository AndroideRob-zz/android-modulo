package com.konarskirob.di

import android.app.Activity
import androidx.fragment.app.Fragment

interface BaseComponentProvider {

    fun provideBaseComponent(): BaseComponent
}

fun Activity.baseComponent() =
    (applicationContext as? BaseComponentProvider)?.provideBaseComponent()
        ?: throw IllegalStateException("BaseComponentProvider not implemented: $applicationContext")

fun Fragment.baseComponent() =
    (context?.applicationContext as? BaseComponentProvider)?.provideBaseComponent()
        ?: throw IllegalStateException("BaseComponentProvider not implemented: ${context?.applicationContext}")