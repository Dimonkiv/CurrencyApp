package com.example.currencyapp.di

import android.content.Context
import com.example.currencyapp.di.module.DatabaseModule
import com.example.currencyapp.di.module.MapperModule
import com.example.currencyapp.di.module.NetworkModule
import com.example.currencyapp.di.module.PresenterModule
import com.example.currencyapp.di.module.RepositoryModule
import com.example.currencyapp.di.module.UseCaseModule
import com.example.currencyapp.di.module.UtilsModule
import com.example.currencyapp.ui.screen.currency.CurrencyFragment
import com.example.currencyapp.ui.screen.splash.SplashFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ivankiv on 19,February,2023
 */
@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        PresenterModule::class,
        UtilsModule::class,
        MapperModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: SplashFragment)

    fun inject(fragment: CurrencyFragment)
}