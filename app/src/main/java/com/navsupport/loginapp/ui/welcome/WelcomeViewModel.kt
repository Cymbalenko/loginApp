package com.navsupport.loginapp.ui.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navsupport.loginapp.util.EventLiveData
import com.navsupport.loginapp.util.EventMutableLiveData
import com.navsupport.loginapp.ui.login.common.WelcomeUiEvent
import com.navsupport.loginapp.util.call
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private val _uiEvent = EventMutableLiveData<WelcomeUiEvent>()

    val uiEvent: EventLiveData<WelcomeUiEvent> = _uiEvent

    fun onLogout() = viewModelScope.launch {
        _uiEvent.call(WelcomeUiEvent.Loading(true))
        delay(2000)
        _uiEvent.call(WelcomeUiEvent.Loading(false))
        _uiEvent.call(WelcomeUiEvent.Logout())
    }
}