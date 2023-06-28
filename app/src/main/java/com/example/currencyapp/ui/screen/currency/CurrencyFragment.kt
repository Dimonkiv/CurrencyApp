package com.example.currencyapp.ui.screen.currency

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyapp.AppApplication
import com.example.currencyapp.databinding.FragmentCurrencyBinding
import com.example.currencyapp.domain.ExchangeRate
import javax.inject.Inject

/**
 * Created by ivankiv on 30,November,2022
 */
class CurrencyFragment: Fragment(), CurrencyView {

    private var _binding: FragmentCurrencyBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { CurrencyAdapter(requireContext()) }

    @Inject
    lateinit var presenter: CurrencyPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyBinding.inflate(inflater, container, false)

        initAdapter()
        setListeners()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchItems()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as AppApplication).appComponent.inject(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
        presenter.detachView()
        _binding = null
    }

    private fun initAdapter() {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }
    }

    private fun setListeners() {
        binding.exchangeBtn.setOnClickListener {
            findNavController().navigate(CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyConverterFragment())
        }
    }

    override fun showExchangeRates(items: List<ExchangeRate>) {
        adapter.setItems(items)
    }
}