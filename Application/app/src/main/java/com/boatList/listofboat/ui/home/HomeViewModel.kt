package com.boatList.listofboat.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This application was created by Kevin Pouzaud and Vincent Calatayud and offers different functionalities to test our skills and knowledge.\n\n" +
                "Our project consists in displaying a list of boat types, with an illustration and a description for each type.\n\n" +
                "We wish you a pleasant experience with our application."
    }
    val text: LiveData<String> = _text
}