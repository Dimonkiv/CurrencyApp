package com.example.currencyapp.ui.screen.currency


import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyapp.databinding.FragmentCurrencyBinding
import com.example.currencyapp.di.AppComponent
import com.example.currencyapp.domain.ExchangeRate
import com.example.currencyapp.ui.base.BaseFragment

/**
 * Created by ivankiv on 30,November,2022
 */
class CurrencyFragment: BaseFragment<CurrencyView, CurrencyPresenter, FragmentCurrencyBinding>(
    FragmentCurrencyBinding::inflate
), CurrencyView {

    private val adapter by lazy { CurrencyAdapter(requireContext()) }

    override fun initUI() {
        initAdapter()
        setListeners()
    }

    override fun initDependencies(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchItems()
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