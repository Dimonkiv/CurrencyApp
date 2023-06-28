package com.example.currencyapp.utils

import com.example.currencyapp.data.model.CurrencyIso4217

/**
 * Created by ivankiv on 10,April,2023
 */
interface GsonHelper {

    fun parseJson(source: String): List<CurrencyIso4217>
}