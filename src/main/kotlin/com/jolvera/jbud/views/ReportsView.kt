package com.jolvera.jbud.views

import javafx.scene.control.Label
import javafx.scene.layout.VBox

class ReportsView : VBox() {
    init {
        val label = Label("Reports")
        children.add(label)
    }
}