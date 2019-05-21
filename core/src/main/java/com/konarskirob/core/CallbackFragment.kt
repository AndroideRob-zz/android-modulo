package com.konarskirob.core

import androidx.fragment.app.Fragment

abstract class CallbackFragment<I, T> : Fragment() {

    abstract var input: I?

    abstract var callback: ((T) -> Unit)?

    /**
     * Resets references to avoid potential memory leaks.
     */
    open fun clear() {
        input = null
        callback = null
    }
}