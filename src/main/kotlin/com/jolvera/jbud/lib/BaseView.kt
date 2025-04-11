package com.jolvera.jbud.lib

import org.koin.core.component.KoinComponent

// meant for new views to implement (basically inherit)
/**
 * BaseView is meant for new views to implement and inherit.
 * This interface inherits from KoinComponent to automatically
 * provide the Koin DSL for using things like `by inject()`
 *
 * ## Functions
 * - [onRemove] - **NEEDS** to be implemented to do any sort of cleanup.
 * Cleanup should include the disposal of any used viewModel inheriting from
 * `BaseViewModel`
 *
 * @see BaseViewModel
 * @author Jolvera
 */
interface BaseView: KoinComponent {
    fun onRemove() // do viewmodel.dispose()
}