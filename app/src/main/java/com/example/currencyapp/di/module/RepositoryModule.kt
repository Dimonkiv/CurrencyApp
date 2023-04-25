package com.example.currencyapp.di.module

import com.example.currencyapp.data.datasource.LocalCurrencyDataSource
import com.example.currencyapp.data.datasource.LocalCurrencyDataSourceImpl
import com.example.currencyapp.data.repository.CurrencyRepository
import com.example.currencyapp.data.repository.CurrencyRepositoryImpl
import com.example.currencyapp.db.dao.CurrencyDao
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
        dataSource: LocalCurrencyDataSource,
        gsonHelper: GsonHelper
    ): CurrencyRepository {
        return CurrencyRepositoryImpl(dataSource, gsonHelper)
    }

    @Provides
    fun provideLocalCurrencyDataSource(dao: CurrencyDao): LocalCurrencyDataSource {
        return LocalCurrencyDataSourceImpl(dao)
    }
}