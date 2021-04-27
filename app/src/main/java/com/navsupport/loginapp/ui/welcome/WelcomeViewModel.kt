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
    private val _logoutEvent = MutableLiveData<Event<WelcomeUiEvent>>()
    private val _uiEvent = MutableLiveData<Event<WelcomeUiEvent>>()
    private val _paymentEvent = MutableLiveData<Event<WelcomeUiEvent>>()

    val logoutEvent: LiveData<Event<WelcomeUiEvent>> = _logoutEvent
    val uiEvent: LiveData<Event<WelcomeUiEvent>> = _uiEvent
    val paymentEvent: LiveData<Event<WelcomeUiEvent>> = _paymentEvent

    fun onLogout() {
        viewModelScope.launch {
            _uiEvent.value = Event(WelcomeUiEvent.Loading(true))
            delay(2000)
            _logoutEvent.value=Event(WelcomeUiEvent.LogOut(true))
            _uiEvent.value = Event(WelcomeUiEvent.Loading(false))
        }
    }

    fun onPaymentMethods(){
        viewModelScope.launch {
            _paymentEvent.value=Event(WelcomeUiEvent.Payment(false))
        }
    }
}