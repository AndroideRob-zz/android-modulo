package com.konarskirob.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_info.*


internal class InfoFragment : Fragment() {

    lateinit var callback: (() -> Unit)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        close.setOnClickListener { callback() }
    }

    companion object {

        fun newInstance(callback: () -> Unit) = InfoFragment().apply {
            this.callback = callback
        }
    }
}