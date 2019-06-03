package com.konarskirob.di

import android.app.Activity


fun Activity.baseComponent() =
    (applicationContext as? BaseComponentProvider)?.provideBaseComponent()
        ?: throw IllegalStateException("BaseComponentProvider not implemented: $applicationContext")