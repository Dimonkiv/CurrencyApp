package com.example.currencyapp.ui.screen.currency

import com.example.currencyapp.domain.ExchangeRate

/**
 * Created by ivankiv on 27,April,2023
 */
interface CurrencyView {

    fun showExchangeRates(items: List<ExchangeRate>)
}