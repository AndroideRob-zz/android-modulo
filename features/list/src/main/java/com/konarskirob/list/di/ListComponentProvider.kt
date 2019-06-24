package com.konarskirob.list.di

import android.app.Activity
import androidx.fragment.app.Fragment

interface ListComponentProvider {

    fun provideListComponent(): ListComponent
}

internal fun Activity.listComponent() =
    (applicationContext as? ListComponentProvider)?.provideListComponent()
        ?: throw IllegalStateException("ListComponentProvider not implemented: $applicationContext")

internal fun Fragment.listComponent() =
    (context?.applicationContext as? ListComponentProvider)?.provideListComponent()
        ?: throw IllegalStateException("ListComponentProvider not implemented: ${context?.applicationContext}")