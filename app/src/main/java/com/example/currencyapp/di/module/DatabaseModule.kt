package com.example.currencyapp.di.module

import android.content.Context
import androidx.room.Room
import com.example.currencyapp.data.repository.CurrencyRepositoryImpl
import com.example.currencyapp.db.AppDatabase
import com.example.currencyapp.db.dao.CurrencyDao
import com.example.currencyapp.ui.screen.splash.SplashPresenter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ivankiv on 20,February,2023
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "TestDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyDao(db: AppDatabase): CurrencyDao {
        return db.currencyDao()
    }
}