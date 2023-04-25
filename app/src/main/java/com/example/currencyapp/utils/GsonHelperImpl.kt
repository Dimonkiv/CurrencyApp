package com.example.currencyapp.utils

import com.example.currencyapp.db.entity.Currency
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

/**
 * Created by ivankiv on 10,April,2023
 */
class GsonHelperImpl @Inject constructor(
    private val fileReaderHelper: FileReaderHelper,
    private val gson: Gson
) : GsonHelper {

    override fun parseJson(file: String): List<Currency> {
        return gson.fromJson(
            fileReaderHelper.readFile(file),
            object : TypeToken<List<Currency>>() {}.type
        )
    }
}