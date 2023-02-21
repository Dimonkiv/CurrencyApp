package com.example.currencyapp

import android.app.Application
import com.example.currencyapp.di.DaggerAppComponent

/**
 * Created by ivankiv on 20,February,2023
 */
class AppApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
