package com.example.timemanager.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    protected fun registerDisposable(vararg disposable: Disposable) {
        compositeDisposable.addAll(*disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }
}