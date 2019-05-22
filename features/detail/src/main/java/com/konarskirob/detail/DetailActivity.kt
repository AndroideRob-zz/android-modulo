package com.konarskirob.detail

import android.app.Activity
import android.os.Bundle
import com.konarskirob.navigation.Nav
import kotlinx.android.synthetic.main.activity_detail.*


internal class DetailActivity : Activity() {

    private val input: Nav.Detail.Input? by lazy {
        Nav.Detail.input(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        idText.text = input?.id

        accept.setOnClickListener { complete(true) }

        deny.setOnClickListener { complete(false) }
    }

    private fun complete(result: Boolean) {
        setResult(1, Nav.Detail.output(intent, Nav.Detail.Output(result)))
        finish()
    }
}