package com.konarskirob.modulo.app

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.konarskirob.modulo.R
import com.konarskirob.navigation.ListHandle

class SplashActivity : Activity() {

    private val listHandle: ListHandle by lazy {
        ListHandle(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(listHandle.getIntent())
            finish()
        }, 1000)
    }
}