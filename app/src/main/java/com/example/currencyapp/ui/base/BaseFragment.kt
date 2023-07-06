package com.example.currencyapp.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.currencyapp.AppApplication
import com.example.currencyapp.di.AppComponent
import javax.inject.Inject

/**
 * Created by ivankiv on 05,July,2023
 */
abstract class BaseFragment<V : BaseView, T : BasePresenter<V>, VB : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment(),
    BaseView {

    private var _binding: VB? = null

    @Inject
    protected lateinit var presenter: T
    protected val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)

        initUI()

        return binding.root
    }

    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initDependencies((requireActivity().application as AppApplication).appComponent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
        presenter.detachView()
        _binding = null
    }

    abstract fun initDependencies(appComponent: AppComponent)

    abstract fun initUI()

}