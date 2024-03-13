package com.vee.zonecompose

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vee.zonecompose.data.repository.FakeNoteRepository
import com.vee.zonecompose.data.viewmodel.BaseViewModel
import com.vee.zonecompose.enum.ScreensEnum
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppNavigationViewModel(val app: Application, val fakeNoteRepository: FakeNoteRepository) :
    BaseViewModel(app, fakeNoteRepository) {
    val currentScreen = MutableLiveData(ScreensEnum.WelCome)

    fun navigateTo(screenName: ScreensEnum) {
        currentScreen.postValue(screenName)
    }

    fun handleSplash() {
        viewModelScope.launch {
            delay(3000)
            navigateTo(ScreensEnum.Home)
        }
    }

}