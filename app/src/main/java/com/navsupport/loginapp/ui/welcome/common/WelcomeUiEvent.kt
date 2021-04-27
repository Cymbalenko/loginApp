package com.navsupport.loginapp.ui.login.common

import androidx.annotation.StringRes

sealed class WelcomeUiEvent {
    class Loading(val isLoading: Boolean) : WelcomeUiEvent()
    class LogOut(val isLoading: Boolean) : WelcomeUiEvent()
    class Payment(val isLoading: Boolean) : WelcomeUiEvent()

    class LoginError(@StringRes val errorStringId: Int) : WelcomeUiEvent()
}
