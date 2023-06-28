package com.example.currencyapp.utils

import com.example.currencyapp.data.model.CurrencyIso4217
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

/**
 * Created by ivankiv on 10,April,2023
 */
class GsonHelperImpl @Inject constructor(
    private val gson: Gson
) : GsonHelper {

    override fun parseJson(source: String): List<CurrencyIso4217> {
        return gson.fromJson(
            source,
            object : TypeToken<List<CurrencyIso4217>>() {}.type
        )
    }
}