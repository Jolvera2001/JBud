package com.jolvera.jbud.ui.viewmodels

import com.jolvera.jbud.domain.RecurrancePattern
import com.jolvera.jbud.domain.RecurringIncome
import com.jolvera.jbud.domain.TransactionType
import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import com.jolvera.jbud.lib.BaseViewModel
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import java.time.Instant
import java.util.UUID

class ItemsViewModel: BaseViewModel() {
    private val items = FXCollections.observableArrayList<RecurringTransaction>()

    init {
        populateItems()
    }

    fun getItems(): ObservableList<RecurringTransaction> {
        return items
    }

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
            )
        )
    }
}