package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import com.jolvera.jbud.ui.viewmodels.ItemsViewModel
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import org.koin.core.component.inject

class ItemsView : VBox(), BaseView {
    private val viewModel: ItemsViewModel by inject()

    init {
        val label = Label("Income")
        children.add(label)
    }

    override fun onRemove() {
        viewModel.dispose()
    }
}