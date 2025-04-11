package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import com.jolvera.jbud.ui.components.TransactionTable
import com.jolvera.jbud.ui.viewmodels.ItemsViewModel
import javafx.geometry.Side
import javafx.scene.layout.VBox
import org.controlsfx.control.MasterDetailPane
import org.controlsfx.control.PropertySheet
import org.koin.core.component.inject

class ItemsView : VBox(), BaseView {
    private val viewModel: ItemsViewModel by inject()

    init {
        val masterView = MasterDetailPane()

        masterView.masterNode = TransactionTable(viewModel.getItems())
        masterView.detailNode = PropertySheet()
        masterView.detailSide = Side.RIGHT

        children.add(masterView)
    }

    override fun onRemove() {
        viewModel.dispose()
    }
}