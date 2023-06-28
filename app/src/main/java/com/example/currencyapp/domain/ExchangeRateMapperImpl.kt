package com.example.currencyapp.domain

import com.example.currencyapp.data.model.Exchange
import com.example.currencyapp.db.entity.Currency

/**
 * Created by ivankiv on 31,May,2023
 */
class ExchangeRateMapperImpl: ExchangeRateMapper {

    override fun map(exchange: Exchange, currency: Currency): ExchangeRate {
        return ExchangeRate(
            currency.name,
            currency.shortName,
            currency.imageName,
            exchange.date,
            exchange.rateSell,
            exchange.rateBuy,
            exchange.rateCross
        )
    }
}