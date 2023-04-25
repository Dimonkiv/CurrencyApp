package com.example.currencyapp.utils

import android.content.Context
import java.io.IOException
import javax.inject.Inject

/**
 * Created by ivankiv on 10,April,2023
 */
class FileReaderHelperImpl @Inject constructor(
    private val context: Context
) : FileReaderHelper {

    override fun readFile(fileName: String): String {
        return try {
            context.assets.open(fileName)
                .bufferedReader()
                .use { it.readText() }
        } catch (ex: IOException) {
            ""
        }
    }

}