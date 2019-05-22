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
            input?.let { putExtra("input", it) }
        }
    }

    fun result(resultCode: Int, intent: Intent?): Output? = intent?.let { intent.getParcelableExtra("output") as? Output }

    fun input(activity: Activity): Input? = activity.intent.getParcelableExtra("input") as? Input

    fun output(intent: Intent, output: Output): Intent = intent.putExtra("output", output)
}