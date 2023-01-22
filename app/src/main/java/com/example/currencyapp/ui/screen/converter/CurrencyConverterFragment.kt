package com.example.currencyapp.ui.screen.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.currencyapp.databinding.FragmentCurrencyConverterBinding
import com.example.currencyapp.ui.dialog.numberinput.NumberInputDialog

/**
 * Created by ivankiv on 29,December,2022
 */
class CurrencyConverterFragment: Fragment(), NumberInputDialog.NumberInputListener {

    private var _binding: FragmentCurrencyConverterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(
            CurrencyConverterFragmentDirections.actionCurrencyConverterFragmentToNumberInputDialog()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSetInput(input: String) = Unit

}