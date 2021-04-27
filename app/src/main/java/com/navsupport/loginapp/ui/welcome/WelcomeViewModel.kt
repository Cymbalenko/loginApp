package com.navsupport.loginapp.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navsupport.loginapp.ui.login.common.WelcomeUiEvent
import com.navsupport.loginapp.util.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private val _logout = MutableLiveData<Event<WelcomeUiEvent>>()
    private val _uiEvent = MutableLiveData<Event<WelcomeUiEvent>>()

    val logout: LiveData<Event<WelcomeUiEvent>> = _logout
    val uiEvent: LiveData<Event<WelcomeUiEvent>> = _uiEvent

    fun onLogout() {
        viewModelScope.launch {
            _uiEvent.value = Event(WelcomeUiEvent.Loading(true))
            delay(2000)
            _logout.value=Event(WelcomeUiEvent.Loading(true))
            _uiEvent.value = Event(WelcomeUiEvent.Loading(false))

        }

    }
}