package com.example.currencyapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ivankiv on 20,February,2023
 */
@Entity
data class FlagIcon(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo("icon_name")
    var iconName: String = ""
)