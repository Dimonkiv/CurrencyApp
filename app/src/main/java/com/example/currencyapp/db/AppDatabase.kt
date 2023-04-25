package com.example.currencyapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencyapp.db.dao.CurrencyDao
import com.example.currencyapp.db.entity.Currency
import com.example.currencyapp.db.entity.FlagIcon

/**
 * Created by ivankiv on 20,February,2023
 */
@Database(entities = [FlagIcon::class, Currency::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao
}