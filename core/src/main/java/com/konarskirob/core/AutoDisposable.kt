package com.konarskirob.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class AutoDisposable(lifecycle: Lifecycle) : LifecycleObserver {

    private val compositeDisposable = CompositeDisposable()

    init {
        lifecycle.addObserver(this)
    }

    fun add(disposable: Disposable) = compositeDisposable.add(disposable)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() = compositeDisposable.dispose()
}