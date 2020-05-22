package com.example.sampleapplicationforgm.event

open class CustomEvent<T>(private val content: T) {
    var isEventHasBeenHandled = false
        private set

    val contentIfEventNotHandled: T?
        get() = if (isEventHasBeenHandled) {
            null
        } else {
            isEventHasBeenHandled = true
            content
        }

}