package com.konarskirob.data.topics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface Topic<T> {

    fun post(value: T)
}

abstract class LiveDataTopic<T> : Topic<T> {

    val data: LiveData<T> = MutableLiveData()

    override fun post(value: T) = (data as MutableLiveData).postValue(value)
}

abstract class RxTopic<T> : Topic<T> {

    val data: Observable<T> = PublishSubject.create<T>()

    override fun post(value: T) = (data as PublishSubject).onNext(value)
}