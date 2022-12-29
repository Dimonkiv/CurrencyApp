package com.example.currencyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currencyapp.databinding.FragmentCurrencyConverterBinding
import com.example.currencyapp.databinding.FragmentCurrencyDetailBinding

/**
 * Created by ivankiv on 29,December,2022
 */
class CurrencyConverterFragment: Fragment() {

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}