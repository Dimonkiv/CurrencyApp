package com.example.currencyapp.di.module

import android.content.Context
import com.example.currencyapp.data.datasource.FileCurrencyDataSource
import com.example.currencyapp.data.datasource.FileCurrencyDataSourceImpl
import com.example.currencyapp.data.repository.CurrencyRepository
import com.example.currencyapp.data.repository.CurrencyRepositoryImpl
import com.example.currencyapp.data.repository.ExchangeRepository
import com.example.currencyapp.data.repository.ExchangeRepositoryImpl
import com.example.currencyapp.db.dao.CurrencyDao
import com.example.currencyapp.domain.CurrencyMapper
import com.example.currencyapp.network.ExchangeService
import com.example.currencyapp.utils.GsonHelper
import dagger.Module
import dagger.Provides

/**
 * Created by ivankiv on 15,April,2023
 */
@Module
class RepositoryModule {

    @Provides
    fun provideCurrencyRepository(
        currencyDao: CurrencyDao,
        dataSource: FileCurrencyDataSource,
        mapper: CurrencyMapper
    ): CurrencyRepository {
        return CurrencyRepositoryImpl(currencyDao, dataSource, mapper)
    }

    @Provides
    fun provideExchangeRepository(
        service: ExchangeService
    ) : ExchangeRepository {
        return ExchangeRepositoryImpl(service)
    }

    @Provides
    fun provideFileCurrencyDataSource(
        context: Context,
        gsonHelper: GsonHelper
    ): FileCurrencyDataSource {
        return FileCurrencyDataSourceImpl(context, gsonHelper)
    }
}