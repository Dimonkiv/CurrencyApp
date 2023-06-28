package com.example.currencyapp.data.repository

import com.example.currencyapp.data.model.Exchange
import com.example.currencyapp.network.ExchangeService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ivankiv on 30,May,2023
 */
class ExchangeRepositoryImpl @Inject constructor(
    private val service: ExchangeService
) : ExchangeRepository {

    override fun fetchExchangeList(): Single<List<Exchange>> {
        return service.getExchangeRates()
            .flatMapIterable { list -> list }
            .filter { item -> item.currencyB != "840" }
            .toList()
    }
}