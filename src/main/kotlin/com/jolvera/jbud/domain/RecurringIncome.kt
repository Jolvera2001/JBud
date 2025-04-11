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

class RecurringIncome(
    override val id: UUID = UUID.randomUUID(),
    override val dateAdded: Instant,
    override val dateUpdated: Instant,
    override val name: String,
    override val description: String,
    override val amount: Double,
    override val transactionDate: Instant,
    override val type: TransactionType,
    override val pattern: RecurrancePattern,
    val source: String,
    val notes: String,
    val isGuaranteed: Boolean
) : RecurringTransaction() {
}

object RecurringIncomeTable: UUIDTable("recurring_income") {
    val transactionId = reference("transaction_id", RecurringTransactionTable.id, ReferenceOption.CASCADE)
    val incomeSource = varchar("source", 50)
    val notes = text("notes")
    val isGuaranteed = bool("is_guaranteed")
}

class RecurringIncomeEntity(id: EntityID<UUID>): UUIDEntity(id) {
    companion object : UUIDEntityClass<RecurringIncomeEntity>(RecurringIncomeTable)

    var transaction by RecurringTransactionEntity referencedOn RecurringIncomeTable.transactionId

    var incomeSource by RecurringIncomeTable.incomeSource
    var notes by RecurringIncomeTable.notes
    var isGuaranteed by RecurringIncomeTable.isGuaranteed
}