package com.example.currencyapp.data.repository

import android.util.Log
import com.example.currencyapp.data.datasource.FileCurrencyDataSource
import com.example.currencyapp.db.dao.CurrencyDao
import com.example.currencyapp.db.entity.Currency
import com.example.currencyapp.domain.CurrencyMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ivankiv on 21,February,2023
 */
class CurrencyRepositoryImpl @Inject constructor(
    private val localDataSource: CurrencyDao,
    private val fileDataSource: FileCurrencyDataSource,
    private val mapper: CurrencyMapper
): CurrencyRepository {

    override fun syncCurrencies(): Single<List<Currency>> {
        return localDataSource.getAll()
            .map { items ->
                if (items.isEmpty()) {
                    return@map saveCurrencies()
                }
             
             return@map items
            }
    }

    private fun saveCurrencies(): List<Currency> {
        return fileDataSource.readData("currency_codes.json")
            .map {currencyIso4217 ->
                mapper.map(currencyIso4217)
            }
            .map {currency ->
                localDataSource.insert(currency)
                return@map currency
            }
    }

}