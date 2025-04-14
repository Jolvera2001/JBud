package com.jolvera.jbud.ui.views

import com.jolvera.jbud.lib.BaseView
import com.jolvera.jbud.ui.components.TransactionDetailWindow
import com.jolvera.jbud.ui.components.TransactionTable
import com.jolvera.jbud.ui.viewmodels.ItemsViewModel
import javafx.geometry.Insets
import javafx.geometry.Side
import javafx.scene.layout.VBox
import org.controlsfx.control.MasterDetailPane
import org.controlsfx.control.PropertySheet
import org.koin.core.component.inject

class ItemsView : VBox(), BaseView {
    private val viewModel: ItemsViewModel by inject()

    init {
        padding = Insets(25.0)

        val masterView = MasterDetailPane()

        masterView.masterNode = TransactionTable(viewModel.getItems(), viewModel::setSelectedItem)
        masterView.detailNode = TransactionDetailWindow(viewModel.getSelectedItem())
        masterView.detailSide = Side.RIGHT

        children.add(masterView)
    }

    override fun onRemove() {
        viewModel.dispose()
    }
}