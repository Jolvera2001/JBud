package com.jolvera.jbud.views

import javafx.scene.control.Label
import javafx.scene.layout.VBox

class IncomeView : VBox() {
    init {
        val label = Label("Income")
        children.add(label)
    }
}