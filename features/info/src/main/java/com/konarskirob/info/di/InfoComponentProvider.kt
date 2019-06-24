package com.konarskirob.info.di

import android.app.Activity
import androidx.fragment.app.Fragment

interface InfoComponentProvider {

    fun provideInfoComponent(): InfoComponent
}

internal fun Activity.infoComponent() =
    (applicationContext as? InfoComponentProvider)?.provideInfoComponent()
        ?: throw IllegalStateException("InfoComponentProvider not implemented: $applicationContext")

internal fun Fragment.infoComponent() =
    (context?.applicationContext as? InfoComponentProvider)?.provideInfoComponent()
        ?: throw IllegalStateException("InfoComponentProvider not implemented: ${context?.applicationContext}")