package com.example.currencyapp.ui.dialog.selectcurrency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyapp.databinding.DialogNumberInputBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by ivankiv on 22,January,2023
 */
class SelectCurrencyDialog : BottomSheetDialogFragment() {

    private var _binding: DialogNumberInputBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogNumberInputBinding.inflate(inflater, container, false)

        return binding.root
    }
}