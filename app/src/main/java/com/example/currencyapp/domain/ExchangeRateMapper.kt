package com.example.currencyapp.domain

import com.example.currencyapp.data.model.Exchange
import com.example.currencyapp.db.entity.Currency

/**
 * Created by ivankiv on 31,May,2023
 */
interface ExchangeRateMapper {

    fun map(exchange: Exchange, currency: Currency): ExchangeRate
}