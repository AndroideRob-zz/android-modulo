package com.konarskirob.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


sealed class Nav {

    object Info : FragmentInterface<Info.Input, Info.Callback> {

        override val className = "com.konarskirob.info.InfoFragment"

        data class Input(val id: String)

        interface Callback {
            fun onClose()
            fun onAction()
        }
    }

    object List : ActivityInterface<Nothing, Nothing> {

        override val className = "com.konarskirob.list.ListActivity"
    }

    object Detail : ActivityInterface<Detail.Input, Detail.Output> {

        override val className = "com.konarskirob.detail.DetailActivity"

        @Parcelize
        data class Input(val id: String) : Parcelable

        @Parcelize
        data class Output(val success: Boolean) : Parcelable
    }
}