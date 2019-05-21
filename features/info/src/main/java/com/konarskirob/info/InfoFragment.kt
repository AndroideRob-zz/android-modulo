package com.konarskirob.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.konarskirob.core.CallbackFragment
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : CallbackFragment<Unit, String>() {

    override var input: Unit? = null

    override var callback: ((String) -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        close.setOnClickListener { callback?.invoke("My result") }
    }
}