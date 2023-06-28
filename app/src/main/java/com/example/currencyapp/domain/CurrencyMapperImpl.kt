package com.example.currencyapp.domain

import com.example.currencyapp.data.model.CurrencyIso4217
import com.example.currencyapp.db.entity.Currency

/**
 * Created by ivankiv on 14,June,2023
 */
class CurrencyMapperImpl : CurrencyMapper {

    override fun map(currencyIso4217: CurrencyIso4217): Currency {
        return Currency(
            shortName = currencyIso4217.shortName,
            name = currencyIso4217.name,
            code = currencyIso4217.code,
            imageName = "ic_flag_${currencyIso4217.countryCode.lowercase()}"
        )
    }
}