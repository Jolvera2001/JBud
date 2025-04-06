package com.jolvera.jbud

import com.jolvera.jbud.components.TransactionForm
import com.jolvera.jbud.models.Transaction
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.control.ListView

class HelloView//        ListView<Transaction>() transactionView = ListView<Transaction>()
public constructor() : VBox() {
    private val viewModel = HelloViewModel()

    init {
        alignment = Pos.CENTER
        spacing = 20.0
        padding = Insets(20.0)

        var hbox = HBox()
        var form = TransactionForm(
            viewModel.getTransactionNameProperty(),
            viewModel.getAmountProperty(),
            viewModel::submitTransaction
        )
        var transactionView = ListView<Transaction>()
        transactionView.itemsProperty().bind(viewModel.getTransactionListProperty())

        hbox.children.addAll(form, transactionView)
        children.add(hbox)
    }
}