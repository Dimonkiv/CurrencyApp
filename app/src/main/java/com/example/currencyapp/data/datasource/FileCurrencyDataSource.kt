package com.example.currencyapp.data.datasource

import com.example.currencyapp.data.model.CurrencyIso4217

/**
 * Created by ivankiv on 29,May,2023
 */
interface FileCurrencyDataSource {

    fun readData(fileName: String): List<CurrencyIso4217>
}