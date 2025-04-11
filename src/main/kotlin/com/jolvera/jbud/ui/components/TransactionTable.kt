package com.jolvera.jbud.ui.components

import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class TransactionTable(
    itemsList: ObservableList<RecurringTransaction>
): TableView<RecurringTransaction>() {
    init {
        val name = TableColumn<RecurringTransaction, String>("Name")
        name.setCellValueFactory { cellData ->
            ReadOnlyStringWrapper(cellData.value.name)
        }

        val description = TableColumn<RecurringTransaction, String>("Description")
        description.setCellValueFactory { cellData ->
            ReadOnlyStringWrapper(cellData.value.description)
        }

        val amount = TableColumn<RecurringTransaction, Double>("Amount")
        amount.setCellValueFactory { cellData ->
            ReadOnlyObjectWrapper(cellData.value.amount)
        }

        val type = TableColumn<RecurringTransaction, String>("Type")
        type.setCellValueFactory { cellData ->
            ReadOnlyStringWrapper(cellData.value.type.toString())
        }

        val pattern = TableColumn<RecurringTransaction, String>("Pattern")
        pattern.setCellValueFactory { cellData ->
            ReadOnlyStringWrapper(cellData.value.pattern.toString())
        }

        val transactionDate = TableColumn<RecurringTransaction, String>("TransactionDate")
        transactionDate.setCellValueFactory { cellData ->
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC)
            ReadOnlyStringWrapper(formatter.format(cellData.value.transactionDate))
        }

        columns.addAll(name, description, amount, type, pattern, transactionDate)

        items = itemsList
    }
}