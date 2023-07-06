package com.example.currencyapp.ui.screen.currency

import com.example.currencyapp.domain.ExchangeRate
import com.example.currencyapp.ui.base.BaseView

/**
 * Created by ivankiv on 27,April,2023
 */
interface CurrencyView : BaseView {

    fun showExchangeRates(items: List<ExchangeRate>)
}