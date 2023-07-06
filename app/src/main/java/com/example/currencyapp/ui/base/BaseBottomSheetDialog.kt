package com.example.currencyapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.currencyapp.AppApplication
import com.example.currencyapp.di.AppComponent
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

/**
 * Created by ivankiv on 06,July,2023
 */
abstract class BaseBottomSheetDialog<V : BaseView, T : BasePresenter<V>, VB : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BottomSheetDialogFragment(), BaseView {

    private var _binding: VB? = null

    @Inject
    protected lateinit var presenter: T
    protected val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies((requireActivity().application as AppApplication).appComponent)
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
        presenter.detachView()
        _binding = null
    }

    abstract fun initDependencies(appComponent: AppComponent)

    abstract fun initUI()

}