package com.example.currencyapp.domain

import android.util.Log
import com.example.currencyapp.data.repository.CurrencyRepository
import com.example.currencyapp.data.repository.ExchangeRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ivankiv on 30,May,2023
 */
class ExchangeRateUseCaseImpl @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val exchangeRepository: ExchangeRepository,
    private val mapper: ExchangeRateMapper
) : ExchangeRateUseCase {

    override fun fetchExchangeRateList(): Single<List<ExchangeRate>> {
        val currencyFlow = currencyRepository.syncCurrencies()
        val exchangeFlow = exchangeRepository.fetchExchangeList()

        return exchangeFlow.zipWith(currencyFlow) { exchangeItems, currencyItems ->
            val items: MutableList<ExchangeRate> = mutableListOf()

            for (ex in exchangeItems) {
                val currency = currencyItems.find {it.code == ex.currencyA}

                currency?.let {
                    val exchangeRate = mapper.map(ex, it)
                    items.add(exchangeRate)
                }
            }

            return@zipWith items
        }

    }
}