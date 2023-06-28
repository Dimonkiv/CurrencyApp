package com.example.currencyapp.di.module

import com.example.currencyapp.data.repository.CurrencyRepository
import com.example.currencyapp.data.repository.ExchangeRepository
import com.example.currencyapp.domain.ExchangeRateMapper
import com.example.currencyapp.domain.ExchangeRateUseCase
import com.example.currencyapp.domain.ExchangeRateUseCaseImpl
import dagger.Module
import dagger.Provides

/**
 * Created by ivankiv on 05,June,2023
 */
@Module
class UseCaseModule {

    @Provides
    fun provideExchangeRateUseCase(
        currencyRepository: CurrencyRepository,
        exchangeRepository: ExchangeRepository,
        mapper: ExchangeRateMapper
    ): ExchangeRateUseCase {
        return ExchangeRateUseCaseImpl(currencyRepository, exchangeRepository, mapper)
    }
}