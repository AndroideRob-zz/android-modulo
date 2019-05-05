package com.konarskirob.detail

import android.app.Activity
import android.os.Bundle
import com.konarskirob.navigation.Navigation
import kotlinx.android.synthetic.main.activity_detail.*

internal class DetailActivity : Activity() {

    private val id: String by lazy {
        intent.getStringExtra(Navigation.Detail.ExtraId) ?: throw Exception()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        idText.text = id

        accept.setOnClickListener { complete(true) }

        deny.setOnClickListener { complete(false) }
    }

    private fun complete(result: Boolean) {
        setResult(Navigation.Detail.ResultCode, intent.apply { putExtra(Navigation.Detail.ExtraResult, result) })
        finish()
    }
}