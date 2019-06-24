package com.konarskirob.core.extensions

import androidx.lifecycle.LifecycleOwner
import com.konarskirob.core.AutoDisposable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.listen(
        lifecycleOwner: LifecycleOwner,
        subscribeOn: Scheduler = Schedulers.io(),
        observeOn: Scheduler = AndroidSchedulers.mainThread(),
        subscribe: (T) -> Unit
): Disposable {

    val disposable = AutoDisposable(lifecycleOwner.lifecycle)

    return subscribeOn(subscribeOn)
            .observeOn(observeOn)
            .subscribe { value -> subscribe(value) }
            .addTo(disposable)
}

private fun Disposable.addTo(autoDisposable: AutoDisposable): Disposable {
    autoDisposable.add(this)
    return this
}