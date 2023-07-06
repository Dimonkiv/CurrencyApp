package com.example.currencyapp.ui.dialog.numberinput

import com.example.currencyapp.ui.base.BaseView

/**
 * Created by ivankiv on 06,January,2023
 */
interface NumberInputView : BaseView {

    fun showInput(input: String)

    fun convertInput(input: String)
}