package com.konarskirob.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.konarskirob.core.NavigationFragment
import com.konarskirob.navigation.Nav
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : NavigationFragment<Nav.Info.Input, Nav.Info.Callback>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        action.setOnClickListener {
            callback?.onAction()
        }

        close.setOnClickListener {
            callback?.onClose()
        }
    }
}