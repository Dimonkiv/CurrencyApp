package com.example.currencyapp.ui.screen.splash

import android.util.Log
import com.example.currencyapp.data.repository.CurrencyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by ivankiv on 21,February,2023
 */
class SplashPresenter @Inject constructor(
    private val repository: CurrencyRepository
) {

    private val disposable = CompositeDisposable()

    private var view: SplashView? = null

    fun attachView(view: SplashView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun unsubscribe() {
        disposable.clear()
    }

    fun syncCurrencyData() {
        val subscription = repository.syncCurrencies()
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("TEST", "Sync was succeed")
                    view?.openCurrencyScreen()
                },
                {
                    Log.e("TEST", it?.localizedMessage ?: "")
                }
            )

        disposable.add(subscription)
    }

}