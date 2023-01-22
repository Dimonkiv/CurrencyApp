package com.example.currencyapp.ui.dialog.numberinput

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyapp.R
import com.example.currencyapp.databinding.DialogNumberInputBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by ivankiv on 05,January,2023
 */
class NumberInputDialog : BottomSheetDialogFragment(), NumberInputView {

    private var _binding: DialogNumberInputBinding? = null
    private var _presenter: NumberInputPresenter? = null
    private var listener: NumberInputListener? = null

    private val binding get() = _binding!!
    private val presenter get() = _presenter!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _presenter = NumberInputPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogNumberInputBinding.inflate(inflater, container, false)

        setListeners()

        return binding.root
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _presenter = null
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