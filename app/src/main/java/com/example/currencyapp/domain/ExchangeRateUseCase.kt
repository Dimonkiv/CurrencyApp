package com.example.currencyapp.domain

import io.reactivex.Single

/**
 * Created by ivankiv on 30,May,2023
 */
interface ExchangeRateUseCase {

    fun fetchExchangeRateList(): Single<List<ExchangeRate>>
}