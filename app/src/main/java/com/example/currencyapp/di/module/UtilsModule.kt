package com.example.currencyapp.di.module

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
    fun provideGsonHelper(gson: Gson): GsonHelper {
        return GsonHelperImpl(gson)
    }
}