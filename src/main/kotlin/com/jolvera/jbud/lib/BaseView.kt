package com.jolvera.jbud.lib

// meant for new views to implement (basically inherit)
interface BaseView {
    fun onRemove() {
        // do viewmodel.dispose()
    }
}