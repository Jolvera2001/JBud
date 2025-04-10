package com.jolvera.jbud.lib

import kotlinx.coroutines.*
import kotlinx.coroutines.javafx.JavaFx

abstract class BaseViewModel {
    // Create a ViewModel-specific scope that's a child of the app scope
    // Using SupervisorJob so failures in one child don't cancel siblings
    // This is needed because any changes to data thats binded to ui MUST
    // be within JavaFX context. Regular Coroutines are fair game for service
    // logic not affecting ui
    protected val viewModelScope = CoroutineScope(Dispatchers.JavaFx + SupervisorJob())

    // Convenience method to launch coroutines in this ViewModel's scope
    protected fun launch(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(block = block)
    }

    // Clean up when the ViewModel is no longer needed
    fun dispose() {
        viewModelScope.cancel()
    }
}