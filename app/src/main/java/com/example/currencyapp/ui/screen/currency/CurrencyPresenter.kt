package com.example.currencyapp.ui.screen.currency

import android.util.Log
import com.example.currencyapp.domain.ExchangeRateUseCase
import com.example.currencyapp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ivankiv on 27,April,2023
 */
class CurrencyPresenter @Inject constructor(
    private val useCase: ExchangeRateUseCase
) : BasePresenter<CurrencyView>() {

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