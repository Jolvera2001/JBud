package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class ExpensesView : VBox(), BaseView {
    init {
        val label = Label("Expenses")
        children.add(label)
    }

    override fun onRemove() {
        TODO()
    }
}