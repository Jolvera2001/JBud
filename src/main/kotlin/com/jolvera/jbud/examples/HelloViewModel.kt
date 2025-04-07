package com.jolvera.jbud.examples

import javafx.beans.property.*
import javafx.collections.FXCollections

class HelloViewModel {
    private val transactionNameProperty = SimpleStringProperty()
    private val amountProperty = SimpleStringProperty()
    private val transactionListProperty = SimpleObjectProperty(FXCollections.observableArrayList<Transaction>())

    init {
        populateList()
    }

    fun getTransactionNameProperty(): StringProperty = transactionNameProperty
    fun getAmountProperty(): StringProperty = amountProperty
    fun getTransactionListProperty() = transactionListProperty

    fun submitTransaction() {
        var newTransaction = Transaction(
            transactionNameProperty.get(),
            amountProperty.get().toDouble()
        )

        val list = transactionListProperty.get()
        list.add(newTransaction)
        clear();
    }

    private fun clear() {
        transactionNameProperty.set("")
        amountProperty.set("")
    }

    private fun populateList() {
        transactionListProperty.set(
            FXCollections.observableArrayList(
                Transaction("Movies", 24.50),
                Transaction("Groceries", 145.65),
                Transaction("Shovel", 12.45)
            )
        )
    }
}