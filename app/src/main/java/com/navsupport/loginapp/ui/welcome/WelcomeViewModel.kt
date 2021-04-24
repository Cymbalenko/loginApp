package com.navsupport.loginapp.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navsupport.loginapp.ui.login.common.LogoutUiEvent
import com.navsupport.loginapp.util.Event
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private val _logout = MutableLiveData<Boolean>()
    private val _uiEvent = MutableLiveData<Event<LogoutUiEvent>>()

    val logout: LiveData<Boolean> = _logout
    val uiEvent: LiveData<Event<LogoutUiEvent>> = _uiEvent

    fun onLogout() {
        viewModelScope.launch {
            _uiEvent.value = Event(LogoutUiEvent.Loading(true))
            delay(2000)
            _logout.value=true

            _uiEvent.value = Event(LogoutUiEvent.Loading(false))

        }

    }
}