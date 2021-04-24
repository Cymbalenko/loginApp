package com.navsupport.loginapp.util

class Event<T>(private var data: T? = null) {

    var isHandled = false
        private set

    fun getIfNotHandled(): T? {
        return if (isHandled) {
            null
        } else {
            isHandled = true
            data
        }
    }

    fun peekData() = data
}
