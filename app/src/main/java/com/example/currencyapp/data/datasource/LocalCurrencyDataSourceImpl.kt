package com.example.currencyapp.data.datasource

import com.example.currencyapp.data.datasource.LocalCurrencyDataSource
import com.example.currencyapp.db.dao.CurrencyDao
import com.example.currencyapp.db.entity.Currency
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ivankiv on 23,March,2023
 */
class LocalCurrencyDataSourceImpl @Inject constructor(
    private val currencyDao: CurrencyDao
) : LocalCurrencyDataSource {

    override fun insert(currency: Currency) {
        return currencyDao.insert(currency)
    }

    override fun getAll(): Single<List<Currency>> {
        return currencyDao.getAll()
    }

    override fun getItemById(id: Int): Single<Currency> {
        return currencyDao.getItemById(id)
    }

}