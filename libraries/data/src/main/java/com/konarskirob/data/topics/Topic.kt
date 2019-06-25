package com.konarskirob.data.topics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface Topic<D, T> {

    val data: D

    fun post(value: T)
}

abstract class LiveDataTopic<T> : Topic<LiveData<T>, T> {

    override val data: LiveData<T> = MutableLiveData()

    override fun post(value: T) = (data as MutableLiveData).postValue(value)
}

abstract class RxPublishTopic<T> : Topic<Observable<T>, T> {

    override val data: Observable<T> = PublishSubject.create<T>()

    override fun post(value: T) = (data as PublishSubject).onNext(value)
}

abstract class ArgumentTopic<T> : Topic<T, T> {

    private var _data: T? = null

    override val data: T
        @Synchronized
        get() {
            val current = _data
            current?.let {
                _data = null
                return current
            } ?: throw IllegalStateException("Data can only be read once from an ArgumentTopic")
        }

    override fun post(value: T) {
        _data = value
    }
}