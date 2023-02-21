package com.example.currencyapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencyapp.db.FlagIcon

/**
 * Created by ivankiv on 20,February,2023
 */
@Database(entities = [FlagIcon::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
}