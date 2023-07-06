package com.example.currencyapp.ui.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ivankiv on 05,July,2023
 */
open class BasePresenter<V> {

    protected var view: V? = null
    protected val disposable = CompositeDisposable()

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun unsubscribe() {
        disposable.clear()
    }
}