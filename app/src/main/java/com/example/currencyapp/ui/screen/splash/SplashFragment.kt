package com.example.currencyapp.ui.screen.splash

import androidx.navigation.fragment.findNavController
import com.example.currencyapp.databinding.FragmentSplashBinding
import com.example.currencyapp.di.AppComponent
import com.example.currencyapp.ui.base.BaseFragment

/**
 * Created by ivankiv on 21,February,2023
 */
class SplashFragment : BaseFragment<SplashView, SplashPresenter, FragmentSplashBinding>(
    FragmentSplashBinding::inflate
), SplashView {

    override fun initUI() {
        presenter.syncCurrencyData()
    }

    override fun initDependencies(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun openCurrencyScreen() {
        findNavController().navigate(
            SplashFragmentDirections.actionSplashFragmentToCurrencyFragment()
        )
    }
}