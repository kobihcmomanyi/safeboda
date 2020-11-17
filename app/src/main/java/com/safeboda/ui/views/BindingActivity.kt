package com.safeboda.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Abstract Activity to create a [ViewDataBinding] for the given type when setting the content view.
 */
abstract class BindingActivity<T : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutResId: Int

    protected lateinit var dataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
    }

    override fun onDestroy() {
        if (::dataBinding.isInitialized) {
            dataBinding.unbind()
        }
        super.onDestroy()
    }

}