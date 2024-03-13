package com.vee.zonecompose.data.viewmodel.vmProvider

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.vee.zonecompose.data.viewmodel.BaseViewModel

open class BaseViewModelProviderFactory(private val vm: BaseViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return vm as T
    }
}