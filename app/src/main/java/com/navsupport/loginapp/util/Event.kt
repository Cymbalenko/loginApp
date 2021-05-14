package com.navsupport.loginapp.util


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

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

typealias EventMutableLiveData <T> = MutableLiveData<Event<T>>
typealias EventLiveData <T> = LiveData<Event<T>>

fun <T> MutableLiveData<Event<T>>.call(data: T) {
    value = Event(data)
}

fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, onEventCalled: (T) -> Unit) {
    observe(owner) { event ->
        event?.getIfNotHandled()?.let { data ->
            onEventCalled(data)
        }
    }
}
