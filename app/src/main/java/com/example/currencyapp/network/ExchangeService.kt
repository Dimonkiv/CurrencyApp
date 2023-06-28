package com.example.currencyapp.network

import com.example.currencyapp.data.model.Exchange
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ivankiv on 27,April,2023
 */
interface ExchangeService {

    @GET("bank/currency")
    fun getExchangeRates(): Observable<List<Exchange>>




}