package com.example.currencyapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by ivankiv on 21,February,2023
 */
@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("code")
    @ColumnInfo(name = "short_name")
    val shortName: String,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,
    @SerializedName("number")
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "icon")
    var icon: String = ""
)