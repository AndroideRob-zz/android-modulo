package com.konarskirob.core

import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

abstract class NavigationFragment<Input, Callback> : Fragment() {

    var input: Input? = null

    var callback: Callback?
        get() = callbackRef?.get()
        set(value) {
            callbackRef = value?.let { WeakReference(value) }
        }

    private var callbackRef: WeakReference<Callback>? = null
}