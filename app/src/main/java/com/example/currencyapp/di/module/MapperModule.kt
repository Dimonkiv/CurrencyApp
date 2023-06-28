package com.example.currencyapp.di.module

import com.example.currencyapp.domain.CurrencyMapper
import com.example.currencyapp.domain.CurrencyMapperImpl
import com.example.currencyapp.domain.ExchangeRateMapper
import com.example.currencyapp.domain.ExchangeRateMapperImpl
import dagger.Module
import dagger.Provides

/**
 * Created by ivankiv on 05,June,2023
 */

@Module
class MapperModule {

    @Provides
    fun provideExchangeRateMapper(): ExchangeRateMapper {
        return ExchangeRateMapperImpl()
    }

    @Provides
    fun provideCurrencyMapper(): CurrencyMapper {
        return CurrencyMapperImpl()
    }
}