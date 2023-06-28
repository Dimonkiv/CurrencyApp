package com.example.currencyapp.data.repository

import com.example.currencyapp.data.model.Exchange
import io.reactivex.Single

/**
 * Created by ivankiv on 30,May,2023
 */
interface ExchangeRepository {

    fun fetchExchangeList(): Single<List<Exchange>>
}