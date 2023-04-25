package com.example.currencyapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.currencyapp.db.entity.Currency
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ivankiv on 20,February,2023
 */
@Dao
interface CurrencyDao {

    @Insert
    fun insert(currency: Currency)

    @Query("SELECT * from currency")
    fun getAll(): Single<List<Currency>>

    @Query("SELECT * from currency WHERE id = :id")
    fun getItemById(id: Int): Single<Currency>
}