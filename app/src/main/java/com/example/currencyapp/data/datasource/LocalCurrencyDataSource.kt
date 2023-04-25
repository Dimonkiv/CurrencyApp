package com.example.currencyapp.data.datasource

import com.example.currencyapp.db.entity.Currency
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ivankiv on 23,March,2023
 */
interface LocalCurrencyDataSource {

    fun insert(currency: Currency)

    fun getAll(): Single<List<Currency>>

    fun getItemById(id: Int): Single<Currency>
}