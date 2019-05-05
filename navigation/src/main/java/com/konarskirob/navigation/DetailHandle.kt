package com.konarskirob.navigation

import android.content.Context
import android.content.Intent
import com.konarskirob.detail.DetailFeature

class DetailHandle(context: Context) {

    data class Input(override val id: String) : DetailFeature.Input

    data class Result(override val status: Boolean) : DetailFeature.Result

    private val feature = DetailFeature(context.applicationContext)

    fun getIntent(input: Input): Intent = feature.getIntent(input)

    fun getResult(resultCode: Int, intent: Intent?): Result? {
        return feature.getResult(resultCode, intent)?.let {
            Result(it.status)
        }
    }
}