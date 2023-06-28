package com.example.currencyapp.data.datasource

import android.content.Context
import com.example.currencyapp.data.model.CurrencyIso4217
import com.example.currencyapp.db.entity.Currency
import com.example.currencyapp.utils.GsonHelper
import java.io.IOException
import javax.inject.Inject

/**
 * Created by ivankiv on 29,May,2023
 */
class FileCurrencyDataSourceImpl @Inject constructor(
    private val context: Context,
    private val gsonHelper: GsonHelper
) : FileCurrencyDataSource {

    override fun readData(fileName: String): List<CurrencyIso4217> {
        return try {
            val source = context.assets.open(fileName)
                .bufferedReader()
                .use { it.readText() }

            gsonHelper.parseJson(source)
        } catch (ex: IOException) {
            emptyList()
        }
    }
}