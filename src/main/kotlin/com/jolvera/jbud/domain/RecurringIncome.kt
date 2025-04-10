package com.jolvera.jbud.domain

import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import java.time.Instant
import java.util.*

class RecurringIncome(
    override val id: UUID = UUID.randomUUID(),
    override val dateAdded: Instant,
    override val dateUpdated: Instant,
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