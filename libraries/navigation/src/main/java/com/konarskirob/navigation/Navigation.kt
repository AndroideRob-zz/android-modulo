package com.konarskirob.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.konarskirob.core.NavigationFragment

private const val InfoFragment = "com.konarskirob.info.InfoFragment"
private const val ListActivity = "com.konarskirob.list.ListActivity"
private const val DetailActivity = "com.konarskirob.detail.DetailActivity"

object Navigation {

    private val cache = mutableMapOf<String, Class<*>>()

    private fun <T> loadClass(className: String): Class<T>? {
        return cache.getOrPut(className) {
            try {
                Class.forName(className)
            } catch (e: ClassNotFoundException) {
                return null
            }
        } as? Class<T>
    }

    object Info {

        fun fragment(input: InfoInput? = null, callback: InfoCallback? = null): NavigationFragment<InfoInput, InfoCallback>? {
            val clazz = loadClass<NavigationFragment<InfoInput, InfoCallback>>(InfoFragment)

            return clazz?.newInstance()?.apply {
                this.input = input
                this.callback = callback
            }
        }
    }

    object List {

        fun activity(context: Context): Intent? {
            val clazz = loadClass<Activity>(ListActivity)
            return clazz?.let { Intent(context, it) }
        }
    }

    object Detail {

        const val ResultCode = 1
        const val ExtraResult = "result"

        const val ExtraId = "id"

        fun activity(context: Context, id: String): Intent? {
            val clazz = loadClass<Activity>(DetailActivity)

            return clazz?.let {
                Intent(context, it).apply {
                    putExtra(ExtraId, id)
                }
            }
        }

        fun result(resultCode: Int, intent: Intent?): Boolean? {
            if (resultCode != ResultCode) return null

            return intent?.let {
                if (!it.hasExtra(ExtraResult)) {
                    null
                } else {
                    it.getBooleanExtra(ExtraResult, false)
                }
            }
        }
    }
}

data class InfoInput(val id: String)

interface InfoCallback {

    fun onClose()

    fun onAction()
}