package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import com.jolvera.jbud.lib.BaseViewModel
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class DashboardView : VBox(), BaseView {
    init {
        val label = Label("Dashboard")
        children.add(label)
    }

    override fun onRemove() {
        TODO()
    }
}