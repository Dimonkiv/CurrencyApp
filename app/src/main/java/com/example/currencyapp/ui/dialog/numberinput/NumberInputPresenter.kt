package com.example.currencyapp.ui.dialog.numberinput

/**
 * Created by ivankiv on 06,January,2023
 */
class NumberInputPresenter(private val view: NumberInputView) {

    private var input = ""

    private fun updateInput(input: String) {
        this.input = input
        view.showInput(input)
    }

    /**
     * Button listeners
     */
    fun onNumberButtonClicked(num: String) {
        updateInput(input + num)
    }

    fun onRemoveBtnClicked() {
        updateInput(input.substring(0, input.length - 1))
    }

    fun onDoneBtnClicked() {
        view.convertInput(input)
    }
}