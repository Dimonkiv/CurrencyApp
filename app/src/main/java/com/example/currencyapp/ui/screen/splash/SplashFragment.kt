package com.example.currencyapp.ui.screen.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.currencyapp.AppApplication
import com.example.currencyapp.databinding.FragmentSplashBinding
import javax.inject.Inject

/**
 * Created by ivankiv on 21,February,2023
 */
class SplashFragment : Fragment(), SplashView {

    private var _binding: FragmentSplashBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        presenter.syncCurrencyData()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }

    override fun openCurrencyScreen() {
        findNavController().navigate(
            SplashFragmentDirections.actionSplashFragmentToCurrencyFragment()
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as AppApplication).appComponent.inject(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        presenter.unsubscribe()
        _binding = null
    }
}