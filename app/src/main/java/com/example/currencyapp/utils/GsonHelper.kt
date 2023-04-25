package com.example.currencyapp.utils

import com.example.currencyapp.db.entity.Currency

/**
 * Created by ivankiv on 10,April,2023
 */
interface GsonHelper {

    fun parseJson(file: String): List<Currency>
}