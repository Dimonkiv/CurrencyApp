package com.example.currencyapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.currencyapp.R

/**
 * Created by ivankiv on 06,June,2023
 */
object DrawableHelper {

    private const val DRAWABLE_FOLDER = "drawable"

    fun getDrawableByName(context: Context, resName: String): Drawable? {
        val resId = getResourceByName(context, resName)
        val resIdOrFallback = if (resId != 0) resId else R.drawable.ic_flag_ua

        return ContextCompat.getDrawable(context, resIdOrFallback)
    }

    @SuppressLint("DiscouragedApi")
    private fun getResourceByName(context: Context, resName: String): Int {
        return context.resources.getIdentifier(resName, DRAWABLE_FOLDER, context.packageName)
    }
}