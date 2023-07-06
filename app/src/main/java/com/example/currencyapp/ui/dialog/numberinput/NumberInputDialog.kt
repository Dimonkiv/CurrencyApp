package com.example.currencyapp.ui.dialog.numberinput

import android.content.Context
import com.example.currencyapp.R
import com.example.currencyapp.databinding.DialogNumberInputBinding
import com.example.currencyapp.di.AppComponent
import com.example.currencyapp.ui.base.BaseBottomSheetDialog

/**
 * Created by ivankiv on 05,January,2023
 */
class NumberInputDialog : BaseBottomSheetDialog<NumberInputView, NumberInputPresenter, DialogNumberInputBinding>(
        DialogNumberInputBinding::inflate
    ), NumberInputView {

    private var listener: NumberInputListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NumberInputListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun initUI() {
        setListeners()
    }

    override fun initDependencies(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    private fun setListeners() {
        with(binding) {

            btn1.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.one))
            }

            btn2.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.two))
            }

            btn3.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.three))
            }

            btn4.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.four))
            }

            btn5.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.five))
            }

            btn6.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.six))
            }

            btn7.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.seven))
            }

            btn8.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.eight))
            }

            btn9.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.nine))
            }

            btn0.setOnClickListener {
                presenter.onNumberButtonClicked(getString(R.string.zero))
            }

            doneBtn.setOnClickListener {
                presenter.onDoneBtnClicked()
            }

            removeBtn.setOnClickListener {
                presenter.onRemoveBtnClicked()
            }
        }
    }


    /**
     * Methods to show UI
     */
    override fun showInput(input: String) {
        binding.inputTv.text = input
    }

    override fun convertInput(input: String) {
        listener?.run {
            onSetInput(input)
        }
    }

    interface NumberInputListener {
        fun onSetInput(input: String)
    }

}