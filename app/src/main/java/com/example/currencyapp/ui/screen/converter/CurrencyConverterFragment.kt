package com.example.currencyapp.ui.screen.converter

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.currencyapp.databinding.FragmentCurrencyConverterBinding
import com.example.currencyapp.di.AppComponent
import com.example.currencyapp.ui.base.BaseFragment
import com.example.currencyapp.ui.dialog.numberinput.NumberInputDialog

/**
 * Created by ivankiv on 29,December,2022
 */
class CurrencyConverterFragment:
    BaseFragment<CurrencyConverterView, CurrencyConverterPresenter, FragmentCurrencyConverterBinding>(
        FragmentCurrencyConverterBinding::inflate
    ), NumberInputDialog.NumberInputListener {

    override fun initUI() {
        TODO("Not yet implemented")
    }

    override fun initDependencies(appComponent: AppComponent) {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(
            CurrencyConverterFragmentDirections.actionCurrencyConverterFragmentToNumberInputDialog()
        )
    }

    override fun onSetInput(input: String) = Unit
}