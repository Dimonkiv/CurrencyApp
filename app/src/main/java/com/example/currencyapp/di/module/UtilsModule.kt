package com.example.currencyapp.di.module

import android.content.Context
import com.example.currencyapp.utils.FileReaderHelper
import com.example.currencyapp.utils.FileReaderHelperImpl
import com.example.currencyapp.utils.GsonHelper
import com.example.currencyapp.utils.GsonHelperImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

/**
 * Created by ivankiv on 10,April,2023
 */
@Module
class UtilsModule {

    @Provides
    fun provideFileReaderHelper(context: Context): FileReaderHelper {
        return FileReaderHelperImpl(context)
    }

    @Provides
    fun provideGsonHelper(fileReaderHelper: FileReaderHelper, gson: Gson): GsonHelper {
        return GsonHelperImpl(fileReaderHelper, gson)
    }
}