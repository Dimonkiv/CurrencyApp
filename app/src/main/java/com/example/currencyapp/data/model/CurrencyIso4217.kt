package com.example.currencyapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ivankiv on 14,June,2023
 */
data class CurrencyIso4217(
    @SerializedName("code")
    var shortName: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("number")
    var code: String = "",
    @SerializedName("country_code")
    var countryCode: String = "",
)