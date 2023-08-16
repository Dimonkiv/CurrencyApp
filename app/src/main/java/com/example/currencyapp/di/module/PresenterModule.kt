package com.example.currencyapp.di.module

import com.example.currencyapp.data.repository.CurrencyRepository
import com.example.currencyapp.domain.ExchangeRateUseCase
import com.example.currencyapp.ui.dialog.numberinput.NumberInputPresenter
import com.example.currencyapp.ui.screen.converter.CurrencyConverterPresenter
import com.example.currencyapp.ui.screen.currency.CurrencyPresenter
import com.example.currencyapp.ui.screen.splash.SplashPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by ivankiv on 15,April,2023
 */
@Module
class PresenterModule {

    @Provides
    fun provideSplashPresenter(repository: CurrencyRepository): SplashPresenter {
        return SplashPresenter(repository)
    }

    @Provides
    fun provideCurrencyPresenter(useCase: ExchangeRateUseCase): CurrencyPresenter {
        return CurrencyPresenter(useCase)
    }

    @Provides
    fun provideNumberInputPresenter(): NumberInputPresenter {
        return NumberInputPresenter()
    }

    @Provides
    fun provideCurrencyConverterPresenter(): CurrencyConverterPresenter {
        return CurrencyConverterPresenter()
    }
}