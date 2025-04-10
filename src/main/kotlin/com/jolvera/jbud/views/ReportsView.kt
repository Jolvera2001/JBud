package com.jolvera.jbud.views

import com.jolvera.jbud.lib.BaseView
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class ReportsView : VBox(), BaseView {
    init {
        val label = Label("Reports")
        children.add(label)
    }

    override fun onRemove() {
        TODO()
    }
}