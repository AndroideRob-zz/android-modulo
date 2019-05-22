package com.konarskirob.navigation

import com.konarskirob.core.NavigationFragment


internal interface FragmentInterface<Input, Callback> {

    val className: String

    fun fragment(input: Input? = null, callback: Callback? = null): NavigationFragment<Input, Callback>? {
        val clazz = Internal.loadClass<NavigationFragment<Input, Callback>>(className)

        return clazz?.newInstance()?.apply {
            this.input = input
            this.callback = callback
        }
    }
}