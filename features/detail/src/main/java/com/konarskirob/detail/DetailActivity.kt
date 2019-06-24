package com.konarskirob.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.konarskirob.navigation.Nav
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        idText.text = input(intent)

        accept.setOnClickListener { complete(true) }

        deny.setOnClickListener { complete(false) }
    }

    private fun complete(result: Boolean) {
        setResult(1, Nav.Detail.output(intent, Nav.Detail.Output(result)))
        finish()
    }

    companion object {

        fun newIntent(context: Context, id: String): Intent =
            Intent(context, DetailActivity::class.java).putExtra("extra", id)

        fun input(intent: Intent) = intent.getStringExtra("extra")
            ?: throw IllegalStateException("extra can't be null")
    }
}