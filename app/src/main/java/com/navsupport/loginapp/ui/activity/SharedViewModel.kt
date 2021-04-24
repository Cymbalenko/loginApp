package com.navsupport.loginapp.ui.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _login = MutableLiveData<String>()

    val login: LiveData<String> = _login

    fun setLogin(login: String) {
        _login.value = login
        Log.d("SharedViewModel", this.login.value.toString())
    }
}