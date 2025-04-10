package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class IncomeView : VBox(), BaseView {
    init {
        val label = Label("Income")
        children.add(label)
    }

    override fun onRemove() {
        TODO()
    }
}