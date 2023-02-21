package com.example.currencyapp.di

import android.content.Context
import androidx.room.Room
import com.example.currencyapp.AppDatabase
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
}