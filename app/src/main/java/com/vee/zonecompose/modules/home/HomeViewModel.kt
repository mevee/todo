package com.vee.zonecompose.modules.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vee.zonecompose.data.Note
import com.vee.zonecompose.data.repository.FakeNoteRepository
import com.vee.zonecompose.data.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(val app: Application, val fakeNoteRepository: FakeNoteRepository) :
    BaseViewModel(app, fakeNoteRepository) {
    val user = MutableLiveData("Vikesh")
    val loadingHard = MutableLiveData<Boolean>(false)
    private val loading = MutableLiveData<Boolean>(false)
    val selectedNotesList = MutableLiveData<MutableList<Note>>()
    private fun loading() = loading.postValue(true)
    private fun hideLoading() = loading.postValue(true)

    fun loadNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            loading()
            delay(2000)
            val data = fakeNoteRepository.getAllNotes().toMutableList()
            selectedNotesList.postValue(data)
            hideLoading()
        }
    }

}