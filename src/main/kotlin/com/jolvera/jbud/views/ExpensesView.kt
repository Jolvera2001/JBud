package com.jolvera.jbud.views

import javafx.scene.control.Label
import javafx.scene.layout.VBox

class ExpensesView : VBox() {
    init {
        val label = Label("Expenses")
        children.add(label)
    }
}