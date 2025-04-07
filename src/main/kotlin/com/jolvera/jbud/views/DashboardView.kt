package com.jolvera.jbud.views

import javafx.scene.control.Label
import javafx.scene.layout.VBox

class DashboardView : VBox() {
    init {
        val label = Label("Dashboard")
        children.add(label)
    }
}