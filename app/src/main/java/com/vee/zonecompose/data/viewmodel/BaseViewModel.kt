package com.vee.zonecompose.data.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.vee.zonecompose.data.repository.BaseRepository

open class BaseViewModel(app: Application, repository: BaseRepository) : ViewModel()