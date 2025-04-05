package com.jolvera.jbud.domain

import com.jolvera.jbud.domain.abstracts.RecurringTransaction
import domain.enums.TransactionType
import java.time.Instant
import java.util.*

class RecurringIncome(
    override val id: UUID = UUID.randomUUID(),
    override val description: String,
    override val amount: Double,
    override val startDate: Instant,
    override val type: TransactionType,
    override val pattern: RecurrancePattern
) : RecurringTransaction() {
    private val source: String? = null
    private val notes: String? = null
    private val isGuaranteed: Boolean? = null
}