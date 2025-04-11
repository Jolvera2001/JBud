package com.jolvera.jbud.domain

import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import com.jolvera.jbud.domain.abstracts.RecurringTransactionEntity
import com.jolvera.jbud.domain.abstracts.RecurringTransactionTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import java.time.Instant
import java.util.*

class RecurringExpense(
    override val id: UUID = UUID.randomUUID(),
    override val dateAdded: Instant,
    override val dateUpdated: Instant,
    override val name: String,
    override val description: String,
    override val amount: Double,
    override val transactionDate: Instant,
    override val type: TransactionType,
    override val pattern: RecurrancePattern,
    val payee: String,
    val paymentMethod: String,
    val notes: String,
    val autoRenewable: Boolean
) : RecurringTransaction() {
}

object RecurringExpenseTable: UUIDTable("recurring_expense") {
    val transactionId = reference("transaction_id", RecurringTransactionTable.id, ReferenceOption.CASCADE)
    val payee = varchar("source", 150)
    val paymentMethod = varchar("payment_method", 100)
    val notes = text("notes")
    val autoRenewable = bool("auto_renewable")
}

class RecurringExpenseEntity(id: EntityID<UUID>): UUIDEntity(id) {
    companion object : UUIDEntityClass<RecurringExpenseEntity>(RecurringExpenseTable)

    var transaction by RecurringTransactionEntity referencedOn RecurringExpenseTable.transactionId

    var payee by RecurringExpenseTable.payee
    var paymentMethod by RecurringExpenseTable.paymentMethod
    var notes by RecurringExpenseTable.notes
    var autoRenewable by RecurringExpenseTable.autoRenewable
}