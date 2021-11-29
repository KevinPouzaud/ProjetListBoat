package com.boatList.listofboat.ui.boatlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoatListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is boat list Fragment"
    }
    val text: LiveData<String> = _text
}