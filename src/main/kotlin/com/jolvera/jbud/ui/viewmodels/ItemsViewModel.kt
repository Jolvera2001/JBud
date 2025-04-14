package com.jolvera.jbud.ui.viewmodels

import com.jolvera.jbud.domain.RecurrancePattern
import com.jolvera.jbud.domain.RecurringIncome
import com.jolvera.jbud.domain.RecurringExpense
import com.jolvera.jbud.domain.TransactionType
import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import com.jolvera.jbud.lib.BaseViewModel
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import java.time.Instant
import java.util.UUID

class ItemsViewModel: BaseViewModel() {
    private val items = FXCollections.observableArrayList<RecurringTransaction>()
    private val selectedItem = SimpleObjectProperty<RecurringTransaction?>()

    init {
        populateItems()
    }

    fun getItems(): ObservableList<RecurringTransaction> {
        return items
    }

    fun getSelectedItem(): SimpleObjectProperty<RecurringTransaction?> {
        return selectedItem
    }

    fun setSelectedItem(item: RecurringTransaction?) {
        selectedItem.set(item)
    }

    // testing purposes
    private fun populateItems() {
        items.addAll(
            RecurringIncome(
                id = UUID.randomUUID(),
                dateAdded = Instant.now(),
                dateUpdated = Instant.now(),
                name = "TestItem1",
                description = "This is a Test Item",
                amount = 2700.00,
                transactionDate = Instant.now(),
                type = TransactionType.SALARY,
                pattern = RecurrancePattern.BIWEEKLY,
                source = "Job",
                notes = "Some notes",
                isGuaranteed = true
            ),
            RecurringExpense(
                id = UUID.randomUUID(),
                dateAdded = Instant.now(),
                dateUpdated = Instant.now(),
                name = "Blimbosoft Subscription",
                description = "Subscription cost related to hosting Teto merch site",
                amount = 40.00,
                transactionDate = Instant.now(),
                type = TransactionType.OTHER_EXPENSE,
                pattern = RecurrancePattern.MONTHLY,
                payee = "Blimbosoft",
                paymentMethod = "Debit",
                notes = "They took my money",
                autoRenewable = true,
            )
        )
    }
}