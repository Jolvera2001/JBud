package com.jolvera.jbud.lib

import kotlinx.coroutines.*
import kotlinx.coroutines.javafx.JavaFx

/**
 * The BaseViewModel class provides an already provided coroutineScope on the javafx thread
 * for new view models to inherit and use
 * @property viewModelScope The property providing the Javafx scope for automatic use
 *
 * ## Functions
 * - [launch] - convenience method for using javafx thread within view models inheriting this class
 * - [dispose] - method to dispose of the coroutine scope to prevent memory leaks
 *
 * ## Use Cases
 * - [View Models] - This class is essential when you need coroutines in a viewmodel for Javafx UI.
 * The nature of JavaFX running UI on a single thread requires the use of this class for clean coroutines.
 * UI changes will need to happen on this thread, so anything relating to UI is handled automatically in this class.
 * When running non-ui work, it's recommended to use `withContext()` for the scope of that work
 *
 * @author Jolvera
 */
abstract class BaseViewModel {
    /**
     * Because kotlin is using Javafx, we need a way to access the Javafx thread for coroutines.
     * This class provides a base for view models when they need to run coroutines,
     * defaulting the CoroutineScope to use the Javafx thread. Any work not affecting UI
     * will need to use another context. Any async work affecting ui will need to use the Javafx scope
     *
     * ## Example
     * ```
     * launch { // automatically uses javafx thread
     *   val = someWork = withContext(Dispatcher.something) {
     *     // no longer in javafx thread
     *     someWork()
     *   }
     *   // back in javafx thread
     *   ...
     * }
     * ```
     */
    protected val viewModelScope = CoroutineScope(Dispatchers.JavaFx + SupervisorJob())

    /**
     * Convenience method for automatically using the Javafx thread when running launch.
     * Nothing special needs to be done, just use "launch {} " like normal
     *
     * ## Example
     * ```
     * // assuming this is in a viewmodel method
     * launch {
     *   // already in javafx thread
     * }
     * ```
     */
    protected fun launch(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(block = block)
    }

    /**
     * This is a method to clean up the coroutine scope.
     * Essential for preventing memory leaks from coroutines
     */
    fun dispose() {
        viewModelScope.cancel()
    }
}