package com.example.currencyapp.data.repository

import android.util.Log
import com.example.currencyapp.data.datasource.LocalCurrencyDataSource
import com.example.currencyapp.db.entity.Currency
import com.example.currencyapp.utils.GsonHelper
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ivankiv on 21,February,2023
 */
class CurrencyRepositoryImpl @Inject constructor(
    private val dataSource: LocalCurrencyDataSource,
    private val gsonHelper: GsonHelper
): CurrencyRepository {

    override fun syncCurrencies(): Single<List<Currency>> {
        return dataSource.getAll()
            .map { items ->
                if (items.isEmpty()) {
                    return@map saveCurrencies()
                }
             
             return@map items
            }
    }

    private fun saveCurrencies(): List<Currency> {
        return gsonHelper.parseJson("currency_codes.json")
            .map {
                it.icon = "ic_flag_${it.shortName.lowercase()}"
                return@map it
            }
            .map {
                dataSource.insert(it)
                return@map it
            }
    }

}