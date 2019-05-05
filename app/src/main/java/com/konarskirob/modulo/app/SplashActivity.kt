package com.konarskirob.modulo.app

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.konarskirob.modulo.R
import com.konarskirob.navigation.Navigation

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Navigation.List.activity(this))
            finish()
        }, 1000)
    }
}