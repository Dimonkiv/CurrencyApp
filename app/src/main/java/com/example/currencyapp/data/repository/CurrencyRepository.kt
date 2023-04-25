package com.example.currencyapp.data.repository

import com.example.currencyapp.db.entity.Currency
import io.reactivex.Single

/**
 * Created by ivankiv on 15,April,2023
 */
interface CurrencyRepository {

    fun syncCurrencies(): Single<List<Currency>>
}