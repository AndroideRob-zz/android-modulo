package com.konarskirob.list.di

import android.app.Activity
import androidx.fragment.app.Fragment

fun Activity.listComponent() =
    (applicationContext as? ListComponentProvider)?.provideListComponent()
        ?: throw IllegalStateException("ListComponentProvider not implemented: $applicationContext")

fun Fragment.listComponent() =
    (context?.applicationContext as? ListComponentProvider)?.provideListComponent()
        ?: throw IllegalStateException("ListComponentProvider not implemented: ${context?.applicationContext}")