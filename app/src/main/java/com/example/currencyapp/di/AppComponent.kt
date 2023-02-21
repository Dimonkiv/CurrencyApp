package com.example.currencyapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Builder
import dagger.Component.Factory
import dagger.Module

/**
 * Created by ivankiv on 19,February,2023
 */
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}