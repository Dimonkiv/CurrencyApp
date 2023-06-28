package com.example.currencyapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ivankiv on 27,April,2023
 */
data class Exchange(
    @SerializedName("currencyCodeA")
    var currencyA: String = "",
    @SerializedName("currencyCodeB")
    var currencyB: String = "",
    @SerializedName("date")
    var date: Long = 0,
    @SerializedName("rateSell")
    var rateSell: String = "",
    @SerializedName("rateBuy")
    var rateBuy: String = "",
    @SerializedName("rateCross")
    var rateCross: String = ""
)
