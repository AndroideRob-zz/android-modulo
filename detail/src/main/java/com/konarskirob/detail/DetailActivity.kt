package com.konarskirob.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

internal class DetailActivity : Activity() {

    private val id: String by lazy {
        intent.getStringExtra(ExtraId) ?: throw Exception()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        idText.text = id

        accept.setOnClickListener {
            setResult(ResultCode, intent.apply { putExtra(ExtraResult, true) })
            finish()
        }

        deny.setOnClickListener {
            setResult(ResultCode, intent.apply { putExtra(ExtraResult, false) })
            finish()
        }
    }

    companion object {

        internal const val ResultCode = 1
        internal const val ExtraResult = "result"

        private const val ExtraId = "id"

        fun newIntent(context: Context, id: String): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(ExtraId, id)
            }
        }
    }
}