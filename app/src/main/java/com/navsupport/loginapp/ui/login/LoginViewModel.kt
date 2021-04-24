package com.navsupport.loginapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s95ammar.loginapp.R
import com.navsupport.loginapp.ui.login.common.LoginUiEvent
import com.navsupport.loginapp.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val _login = MutableLiveData<String>()
//    private val _loginErrorEvent = MutableLiveData<Event<Int>>()
//    private val _loadingEvent = MutableLiveData<Event<Boolean>>()
    private val _uiEvent = MutableLiveData<Event<LoginUiEvent>>()

    val login: LiveData<String> = _login
//    val loginErrorEvent: LiveData<Event<Int>> = _loginErrorEvent
//    val loadingEvent: LiveData<Event<Boolean>> = _loadingEvent
    val uiEvent: LiveData<Event<LoginUiEvent>> = _uiEvent

    fun onLogin(login: String, password: String) {
        // launches a coroutine in the ViewModel and prevents possible leaks from the coroutine
        viewModelScope.launch {
            _uiEvent.value = Event(LoginUiEvent.Loading(true))

            // Fake work to see the loading
            delay(2000) // can only be called inside a coroutine

            if (login == "Vlad" && password == "123456") {
                _login.value = login
            } else {
                _uiEvent.value = Event(LoginUiEvent.LoginError(R.string.error_login_incorrect_credentials))
            }
            _uiEvent.value = Event(LoginUiEvent.Loading(false))

        }

    }
}