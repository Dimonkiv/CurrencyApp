package com.example.currencyapp.di.module

import com.example.currencyapp.data.repository.CurrencyRepository
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
}