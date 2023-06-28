package com.example.currencyapp.domain

/**
 * Created by ivankiv on 30,May,2023
 */
data class ExchangeRate(
    var title: String = "",
    var shortTitle: String = "",
    var icon: String = "",
    var date: Long = 0,
    var rateSell: String = "",
    var rateBuy: String = "",
    var rateCross: String = ""
)
