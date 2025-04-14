package com.jolvera.jbud.ui.components

import com.jolvera.jbud.domain.RecurringExpense
import com.jolvera.jbud.domain.RecurringIncome
import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class TransactionDetailWindow(transactionProperty: SimpleObjectProperty<RecurringTransaction?>) : VBox() {
    init {
        children.clear()

        if (transactionProperty.value != null) {
            createUI(transactionProperty.value!!)
        } else (
            children.add(Label("No item selected"))
        )


        transactionProperty.addListener { _, _, newValue ->
            children.clear()

            if (newValue != null) {
                createUI(newValue)
            } else {
                children.add(Label("No person selected"))
            }
        }
    }

    private fun createUI(transaction: RecurringTransaction) {
        val nameLabel = Label(transaction.name)
        val descriptionLabel = Label(transaction.description)
        val amountLabel = Label(transaction.amount.toString())
        val transactionDateLabel = Label(transaction.transactionDate.toString())
        val typeLabel = Label(transaction.type.toString())
        val patternLabel = Label(transaction.pattern.toString())

        children.addAll(nameLabel, descriptionLabel, amountLabel, transactionDateLabel, typeLabel, patternLabel)

        when (transaction) {
            is RecurringExpense -> {
                val payeeLabel = Label(transaction.payee)
                val paymentMethodLabel = Label(transaction.paymentMethod)
                val notesLabel = Label(transaction.notes)
                val autoRenewLabel = Label(transaction.autoRenewable.toString())
                children.addAll(payeeLabel, paymentMethodLabel, notesLabel, autoRenewLabel)
            }
            is RecurringIncome -> {
                val sourceLabel = Label(transaction.source)
                val notesLabel = Label(transaction.notes)
                val isGuaranteedLabel = Label(transaction.isGuaranteed.toString())
                children.addAll(sourceLabel, notesLabel, isGuaranteedLabel)
            }
        }
    }
}