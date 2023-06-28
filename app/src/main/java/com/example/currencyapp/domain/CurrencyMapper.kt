package com.example.currencyapp.domain

import com.example.currencyapp.data.model.CurrencyIso4217
import com.example.currencyapp.db.entity.Currency

/**
 * Created by ivankiv on 14,June,2023
 */
interface CurrencyMapper {

    fun map(currencyIso4217: CurrencyIso4217): Currency
}