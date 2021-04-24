package com.navsupport.loginapp.ui.login.common

import androidx.annotation.StringRes

sealed class LogoutUiEvent {
    class Loading(val isLoading: Boolean) : LogoutUiEvent()
    class LoginError(@StringRes val errorStringId: Int) : LogoutUiEvent()
}
