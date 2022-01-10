package com.example.timemanager.common

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T : Any> Observable<T>.async(
    subscribe: Scheduler = Schedulers.newThread(),
    observe: Scheduler = AndroidSchedulers.mainThread()
): Observable<T> {
    return this.subscribeOn(subscribe).observeOn(observe)
}

fun <T : Any> T.just(): Observable<T> {
    return Observable.just(this)
}