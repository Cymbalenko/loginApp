package com.navsupport.loginapp.ui.login.common

import androidx.annotation.StringRes

sealed class WelcomeUiEvent {
    class Loading(val isLoading: Boolean) : WelcomeUiEvent()
    class Logout : WelcomeUiEvent()
}
