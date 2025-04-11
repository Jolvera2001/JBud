package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import com.jolvera.jbud.ui.viewmodels.DashboardViewModel
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import org.koin.core.component.inject

class DashboardView : VBox(), BaseView {
    private val viewModel: DashboardViewModel by inject()

    init {
        padding = Insets(25.0)

        val label = Label("Dashboard")
        children.add(label)
    }

    override fun onRemove() {
        viewModel.dispose()
    }
}