package com.boatList.listofboat.ui.aboutus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutUsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "We are work-study students in a professional degree where we learn to develop all sorts of things in different programming languages. We both come from a DUT in Computer Science where we were able to acquire a lot of solid knowledge and skills.\n" +
                "\n" +
                "This is why we decided to do this degree, which is a logical continuation of our career. It is also an opportunity to discover unexplored domains but also to deepen the paths we have already walked.\n" +
                "\n" +
                "PS: Dragon Ball is good, One Piece is not..."
    }
    val text: LiveData<String> = _text
}