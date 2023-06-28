package com.example.currencyapp.ui.screen.currency

import android.util.Log
import com.example.currencyapp.domain.ExchangeRateUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ivankiv on 27,April,2023
 */
class CurrencyPresenter @Inject constructor(
    private val useCase: ExchangeRateUseCase
) {
    private val disposable = CompositeDisposable()

    private var view: CurrencyView? = null

    fun attachView(view: CurrencyView) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    fun unsubscribe() {
        disposable.clear()
    }

    fun fetchItems() {
        val subscription = useCase.fetchExchangeRateList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { items ->
                    view?.showExchangeRates(items)
                },
                { err ->
                    Log.e("TAG", "OnReceiveError - $err")
                }
            )

        disposable.add(subscription)
    }
}