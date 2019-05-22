package com.konarskirob.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent


sealed class Nav {

    object Info : FragmentInterface<Info.Input, Info.Callback> {

        override val className = "com.konarskirob.info.InfoFragment"

        data class Input(val id: String)

        interface Callback {
            fun onClose()
            fun onAction()
        }
    }

    object List {

        private const val ListActivity = "com.konarskirob.list.ListActivity"

        fun activity(context: Context): Intent? {
            val clazz = Internal.loadClass<Activity>(ListActivity)
            return clazz?.let { Intent(context, it) }
        }
    }

    object Detail {

        private const val DetailActivity = "com.konarskirob.detail.DetailActivity"

        const val ResultCode = 1
        const val ExtraResult = "result"

        const val ExtraId = "id"

        fun intent(context: Context, id: String): Intent? {
            val clazz = Internal.loadClass<Activity>(DetailActivity)

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