package com.jolvera.jbud.lib

import org.koin.core.component.KoinComponent

// meant for new views to implement (basically inherit)
interface BaseView: KoinComponent {
    fun onRemove() // do viewmodel.dispose()
}