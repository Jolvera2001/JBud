package com.jolvera.jbud.domain.abstracts

import com.jolvera.jbud.domain.RecurrancePattern
import com.jolvera.jbud.domain.TransactionType
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp
import java.time.Instant
import java.util.*

abstract class RecurringTransaction {
    abstract val id: UUID
    abstract val dateAdded: Instant
    abstract val dateUpdated: Instant
    abstract val description: String
    abstract val amount: Double
    abstract val transactionDate: Instant
    abstract val type: TransactionType
    abstract val pattern: RecurrancePattern
}

object RecurringTransactionTable: UUIDTable("recurring_transaction") {
    val dateAdded = timestamp("date_added")
    val dateUpdated = timestamp("date_updated")
    val description = varchar("description", 255)
    val amount = double("amount")
    val transactionDate = timestamp("transaction_date")
    val type = enumerationByName("type", 50, TransactionType::class)
    val pattern = enumerationByName("pattern", 50, RecurrancePattern::class)
}

class RecurringTransactionEntity(id: EntityID<UUID>): UUIDEntity(id) {
    companion object : UUIDEntityClass<RecurringTransactionEntity>(RecurringTransactionTable)

    var dateAdded by RecurringTransactionTable.dateAdded
    var dateUpdated by RecurringTransactionTable.dateUpdated
    var description by RecurringTransactionTable.description
    var amount by RecurringTransactionTable.amount
    var transactionDate by RecurringTransactionTable.transactionDate
    var type by RecurringTransactionTable.type
    var pattern by RecurringTransactionTable.pattern
}
