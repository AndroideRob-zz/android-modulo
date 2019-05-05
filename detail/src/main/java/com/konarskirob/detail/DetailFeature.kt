package com.konarskirob.detail

import android.content.Context
import android.content.Intent

class DetailFeature(private val context: Context) {

    interface Input {
        val id: String
    }

    interface Result {
        val status: Boolean
    }

    data class ResultImpl(override val status: Boolean) : Result

    fun getIntent(input: Input) = DetailActivity.newIntent(context, input.id)

    fun getResult(resultCode: Int, intent: Intent?): Result? {
        if (resultCode != DetailActivity.ResultCode) return null

        return intent?.let {
            if (!it.hasExtra(DetailActivity.ExtraResult)) {
                null
            } else {
                ResultImpl(it.getBooleanExtra(DetailActivity.ExtraResult, false))
            }
        }
    }
}

