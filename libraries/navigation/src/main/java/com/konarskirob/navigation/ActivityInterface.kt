package com.konarskirob.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable


internal interface ActivityInterface<Input : Parcelable, Output : Parcelable> {

    val className: String

    fun intent(context: Context, input: Input? = null): Intent? {
        val clazz = Internal.loadClass<Activity>(className)

        return Intent(context, clazz).apply {
            putExtra("input", input)
        }
    }

    fun Activity.input() = intent.getParcelableExtra("input") as Input
}