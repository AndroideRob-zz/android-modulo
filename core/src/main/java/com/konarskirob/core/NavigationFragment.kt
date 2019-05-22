package com.konarskirob.core

import androidx.fragment.app.Fragment

abstract class NavigationFragment<Input, Callback> : Fragment() {

    var input: Input? = null

    var callback: Callback? = null

    /**
     * Resets references to avoid potential memory leaks.
     */
    open fun clear() {
        input = null
        callback = null
    }
}